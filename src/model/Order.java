/**@author Aswathi Krishnan
 * Stores all Order related details.
 * @param id is the order id;
 * @param custname is the customer name.
 * @param pname is the product name.
 * @param adress is the adress of the customer.
 * @param price ,quantity denotes for the product.
 */


package model;

import java.sql.Date;
import java.time.LocalDate;

public class Order {

	private String id;
	private String pid;
	private String custname;
	
	private String adress;
	private String price;
	private String quantity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	//public String getPname() {
	//	return pname;
	//}
//	public void setPname(String pname) {
		//this.pname = pname;
	//}
	public String getAdress() {
		return adress;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
	
}
