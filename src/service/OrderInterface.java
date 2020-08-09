/**
 *interface for OrderDAO class.
 */
package service;

import java.sql.SQLException;
import java.util.List;

import model.Order;

public interface OrderInterface {
	
	public void purchase(Order order) throws Exception;
	public List<Order> MyOrders(String name) ;
	public List<Order> getAllOrders();
	public void deleteOrder(String orderId) ;

}
