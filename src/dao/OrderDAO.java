/**
 * class which does all the Order operations, purchase , respective persons order,cancel/delete the order.
 */
package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Order;


import service.OrderInterface;
import utility.ConnectionManager;

public class OrderDAO implements OrderInterface{
	static int status;
	static String sql;
	static ConnectionManager cm = new ConnectionManager();
	static List<Order> list1 = new ArrayList<Order>();
	int price;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
// inserting order in the table
	@Override
	public void purchase(Order order) throws Exception {
		
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.getConnection();
			
			String sql1 = "select * from productsinstore where pid = ?";
			PreparedStatement stt = con.prepareStatement(sql1);
			stt.setString(1,order.getPid());
			ResultSet rs = stt.executeQuery();
			if(rs.next()) {
		price =Integer.parseInt (order.getQuantity())*Integer.parseInt(rs.getString(5));
		String sql = "INSERT INTO orderuserss(id,NAME,PID,ADRESS,PRICE,QUANTITY)VALUES(ORD_SEQ.NEXTVAL ,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, order.getCustname());
		st.setString(2, order.getPid());
		st.setString(3, order.getAdress());
		st.setString(4, price+"");
		st.setString(5, order.getQuantity());
		
		int status = st.executeUpdate();
		if(status > 0) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("**************************Order purchased successfully**********************");
		}else {
			System.out.println("**************************Failure*********************************************");
		}
		con.close();
		
			}else {
				System.out.println("");
				System.out.println("");
				System.out.println("************************PRODUCT ID DOES NOT EXSIST*********************");
			}
			
			
		
	}
	//view respective order by typing name.
	public List<Order> MyOrders(String name) 
	{
		List<Order> list1 = new ArrayList<Order>();
		try 
		{
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.getConnection();
			
			String sql = "Select * from orderuserss where name =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
	
			if(rs.next()==false)
			{
				System.out.println("Sorry!! YOUR CART IS EMPTY...!");
			}
			else
			{
				do{
					Order o = new Order();
					
					String orderId = rs.getString(1);
					String username = rs.getString(2);
					String pid = rs.getString(3);
					String adress = rs.getString(4);
					String pPrice = rs.getString(5);
					String PQuantity = rs.getString(6);
					
					
					o.setId(orderId);
					o.setCustname(username);
					o.setPid(pid);
					o.setAdress(adress);
					o.setPrice(pPrice);
					o.setQuantity(PQuantity);
					
					list1.add(o);
					
					}while(rs.next()); 
			}
			con.close();
		}
		catch (Exception e) {
			e.getMessage();
		}
		return list1;
	}

	
	//cancel order using the order id.
	
	@Override
	public void deleteOrder(String Id)  {
	
		try {
			//System.out.println(Id);
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.getConnection();
			String sql = "DELETE FROM orderuserss WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,Id);
			int stat = st.executeUpdate();
			if(stat > 0) {
				System.out.println("*************************ORDER CANCELLED SUCCESSFULLY ****************************************");
				con.close();
			}else {
				System.out.println("*************************INVALID ORDER ID***************************************************** ");
				con.close();
			}
		}catch (Exception e) 
		{
			e.getMessage();
		}
		
		
		
		
	}

	public List<Order> getAllOrders() {
		try {
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.getConnection();
			String sql = "select * from orderuserss";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				String orderid = rs.getString(1);
				String custname = rs.getString(2);
				String pid = rs.getString(3);
				String adress = rs.getString(4);
				String price = rs.getString(5);
				String quantity = rs.getString(6);
				
				Order order = new Order();
				order.setId(orderid);
				order.setCustname(custname);
				order.setPid(pid);
				order.setAdress(adress);
				order.setPrice(price);
				order.setQuantity(quantity);
				
				list1.add(order);
				
		
			}
			
		}catch (Exception e) 
		{
			e.getMessage();
		}
		
		
		return list1;
	}

}
