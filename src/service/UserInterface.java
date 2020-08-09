/**
 * interface for UserDAO.
 */
package service;

import java.util.List;

import model.Order;
import model.Product;
import model.User;

public interface UserInterface {

	
	public void delete(String Id);
	public List<User> displayUsers();
	public List<Order> getAllOrders() ;
	
}
