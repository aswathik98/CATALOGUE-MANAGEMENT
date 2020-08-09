/**@author Aswathi Krishnan
 * Stores all Customer related details.
 * @param username is the userid of customer .
 * @param name is the name of the customer.
 * @param email is the email of customer. 
 * @param mobile,password of respective customer
 */

package model;

public class User {
private String userid;
private String name;
private String email;
private String password;
private String mobile;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
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
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}


	

}
