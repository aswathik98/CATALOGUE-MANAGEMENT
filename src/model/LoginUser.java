/**@author Aswathi Krishnan
 * Stores all Login related details.
 * @param email is the registered email of the customer;
 * @param password is the registered password of the customer;

 */



package model;

public class LoginUser {
	
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
