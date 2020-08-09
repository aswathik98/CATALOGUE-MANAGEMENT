/**
 * class which is used for adding the products,display all products,delete product using id,search product using id.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import service.ProductInterface;
import utility.ConnectionManager;

public class ProductDAO implements ProductInterface{

static List<Product>list = new ArrayList<Product>();
static Product product = new Product();

//add product details.
public void insert(Product product) throws Exception 
{
	
		ConnectionManager cm = new ConnectionManager();
		Connection con;
		
			con = cm.getConnection();
		
		
		
		String sql = "INSERT INTO productsinstore(pid, pname, category, brand,price) VALUES(in_seq.nextval, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, product.getPname());
		st.setString(2, product.getCategory());
		st.setString(3, product.getBrand());
		st.setInt(4, product.getPrice());
		int status =st.executeUpdate();
		if(status > 0) {
			System.out.println("Success");
		}else {
			System.out.println("Fail");
		}
		con.close();
	
}

//display all product details.
@Override
public List<Product> displayProducts() 
{	
	List<Product> list = new ArrayList<Product>();
	try 
	{
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		String sql = "Select * from productsinstore";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) 
		{
			Product p = new Product();
			int productId = rs.getInt(1);
			String productName = rs.getString(2);
			String category = rs.getString(3);
			String brand = rs.getString(4);
			int price = rs.getInt(5);
			
			
			p.setPid(productId);
			p.setPname(productName);
			p.setCategory(category);
			p.setBrand(brand);
			p.setPrice(price);
		
			list.add(p);
		}
		con.close();
	}
	catch (Exception e) 
	{
		e.getMessage();
	}
	return list;
}
	
	


// delete the product details using product id.

@Override
public void delete(int pid) {
	
	try {
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		String sql = "DELETE FROM productsinStore WHERE pid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, pid);
		int status = ps.executeUpdate();
//		
	if(status > 0) {
			System.out.println("**********************PRODUCT DELETED SUCCESSFULLY****************************");
			con.close();
		}else {
			System.out.println("**********************PRODUCT DOES NOT EXSIST**********************************");
			con.close();
		}
		
		
	}catch (Exception e) 
	{
		e.printStackTrace();
	}
	
}
//Search products using product id.

@Override
public void search(int pid) {
	
	try {
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		String sql = "select pid,pname,category,brand,price from productsinstore where pid = '"+pid+"'";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			
			System.out.println("********************************************************************************************************************************");
			System.out.println("ProductID         ProductName            Category              Brand                   Price ");
			System.out.println("*********************************************************************************************************************************");
			System.out.println(rs.getInt("pid")+"         "+rs.getString("pname")+"            "+rs.getString("category")+"              "+ rs.getString("brand")+"               "+rs.getInt("price"));
		}else {
			System.out.println("    ");
			System.out.println("----------------------------------PRODUCT ID DOES NOT EXSIST---------------------  ");
			System.out.println("    ");
		}
	}catch (Exception e) 
	{
		e.getMessage();
	}
	
}	
	

	

}
