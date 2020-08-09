/**
 * class for generating the bill pdf.
 
 */
package dao;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import utility.ConnectionManager;

public class Bill {
	
	public void generateBill(String name) throws Exception
	{
		
		Document my_bill = new Document();
		PdfWriter.getInstance(my_bill, new FileOutputStream("C:\\Users\\dell\\Desktop\\Billss.pdf"));
		my_bill.open();
		
		Paragraph p = new Paragraph(" Order Details for "+name+"\n");
		p.setAlignment(Paragraph.ALIGN_CENTER);
		my_bill.add(p);
		Paragraph line = new Paragraph("_____________________________________________________________________________\n\n");
		my_bill.add(line);
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		String sql = "Select * from orderuserss where name =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, name);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) 	
			System.out.println("=============================Bill Generated Successfully!!============================");
		else
			System.out.println("=============================Bill Generation Failed!!==============================");
		
		do{
			String orderId = rs.getString(1);
			Paragraph p1 = new Paragraph( "Order ID        :                 "+orderId+"\n");
			my_bill.add(p1);
			String username = rs.getString(2);
			Paragraph p2 = new Paragraph( "Customer Name   :          		 "+username+"\n");
			my_bill.add(p2);
			String pName = rs.getString(3);
			Paragraph p3 = new Paragraph( "Product ID      :          		 "+pName+"\n");
			my_bill.add(p3);
			String padress = rs.getString(4);
			Paragraph p4 = new Paragraph( "Address         :                 "+padress+"\n");
			my_bill.add(p4);
			String pPrice = rs.getString(5);
			Paragraph p5 = new Paragraph( "TOTAL COST      :                Rs"+pPrice+"\n");
			my_bill.add(p5);
			String PQuantity = rs.getString(6);
			Paragraph p6 = new Paragraph("Product Quantity :          		 "+PQuantity+"\n");
			my_bill.add(p6);
			Paragraph last = new Paragraph(" Thank You! Visit Again!");
			last.setAlignment(Paragraph.ALIGN_CENTER);
			my_bill.add(last);
			
		} while(rs.next()); 	
	
	my_bill.close();
	con.close();	
}

}
