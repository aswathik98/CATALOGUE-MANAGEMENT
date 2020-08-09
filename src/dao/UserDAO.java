/**
 * class which does all the admin operations,add products,delete products,view customer details,delete customer details.
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import model.Product;
import model.User;
import service.UserInterface;
import utility.ConnectionManager;

public class UserDAO implements UserInterface{
	static List<User>list = new ArrayList<User>();
	static List<Order>orderlist = new ArrayList<Order>();
	
// display all the customers who have registered.
	public List<User> displayUsers(){
	
		 List<User> userlist = new ArrayList<User>();
			try 
			{
				ConnectionManager cm = new ConnectionManager();
				Connection con = cm.getConnection();
				String sql = "Select * from INV_USER";
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					User user = new User();
					String userId = rs.getString(1);
					String userName = rs.getString(2);
					String email = rs.getString(3);
					String mobile = rs.getString(4);
					String password = rs.getString(5);
					
					user.setUserid(userId);
					user.setName(userName);
					user.setEmail(email);
					user.setMobile(mobile);
					user.setPassword(password);
					userlist.add(user);
					
				}
				con.close();
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			
			return userlist;
	}

// deletes the customer using their cutomer id.
	@Override
	public void delete(String Id) {
		try {
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.getConnection();
			String sql = "DELETE FROM inv_user WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,Id);
			int status = st.executeUpdate();
			if(status > 0) {
				System.out.println("*************************CUSTOMER DETAIL SUCCESSFULLY DELETED****************************************");
			}else {
				System.out.println("*************************CUSTOMER DOES NOT EXSIST***************************************************** ");
			}
		}catch (Exception e) 
		{
			e.getMessage();
		}
		
	}

	
//displays all the orders by respective customers.
	@Override
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
				
				orderlist.add(order);
				
		
			}
			
		}catch (Exception e) 
		{
			e.getMessage();
		}
		
		
		return orderlist;
	}

	
	

	
}
