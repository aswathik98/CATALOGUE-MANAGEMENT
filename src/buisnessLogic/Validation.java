/**
 * used for validation of both admin and customer accounts.ie.Password, email should match these conditions
 */


package buisnessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import model.User;
import model.LoginUser;
import utility.ConnectionManager;

public class Validation  {

	public boolean checkUser(LoginUser loginuser) throws SQLException, Exception
	{	
		String mailid = loginuser.getEmail();
		String password = loginuser.getPassword();
		
		ConnectionManager con = new ConnectionManager();
		Statement st = con.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM INV_USER");
		while(rs.next()) {
			if(mailid.equals(rs.getString("EMAIL")) && password.equals(rs.getString("PASSWORD"))) {
				//System.out.println("Success");
				con.getConnection().close();
				return true;
			}
			
			
		}
		con.getConnection().close();
		return false;
	
}
	
public boolean checkAdmin(LoginUser loginuser) throws SQLException, Exception {
	String username = loginuser.getEmail();
	String pass = loginuser.getPassword();
	ConnectionManager con = new ConnectionManager();
	Statement st = con.getConnection().createStatement();
	ResultSet rs = st.executeQuery("SELECT * FROM ADMIN");
	while(rs.next()) {
		if(username.equals(rs.getString("NAME")) && pass.equals(rs.getString("PASS"))){
			//System.out.println("SUccess");
			con.getConnection().close();
			return true;
		}	
		
	}
	con.getConnection().close();
	return false;
	
}
}
	


