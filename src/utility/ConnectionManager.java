package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {
	
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();	

		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
	
	public static Connection getConnection() throws Exception {
		
		
		Properties newProp = new Properties();
		newProp = loadPropertiesFile();//loadproperties returns properties.
		
		String driver,url,username,password;
		
		driver = newProp.getProperty("driver");//getting value in jdbc assigned to prop.why seperate file is db may change
		url = newProp.getProperty("url");
		username = newProp.getProperty("username");
		password = newProp.getProperty("password");
		
		Class.forName(driver);
		
		//create connection object
		
		Connection con = DriverManager.getConnection(url,username,password);
		
		
		return con;
	}
		
	

}
