/**
 *  interface for ProductDAO.
 */
package service;

import java.sql.SQLException;
import java.util.List;

import model.Product;

public interface ProductInterface {
	
	public List<Product> displayProducts() ;
	public void insert(Product product) throws SQLException, Exception;
	public void delete(int pid);
	public void search(int productId);

}
