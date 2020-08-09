/**@author Aswathi Krishnan
 * Stores all Product related details.
 * @param pid is the product id;
 * @param pname is the product name;
 * @param category ,brand of the respective product.
 */


package model;

public class Product {

	 private int pid;
	 private String pname;
	 private String category;
	 private String brand;
	 
	 private int price;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	 
	 
	
}
