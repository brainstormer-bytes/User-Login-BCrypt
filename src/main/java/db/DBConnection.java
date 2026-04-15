package db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DBConnection {
   Connection con = null;
   public Connection connect() {
	   try {   // learn how to access db.propertise using properties
		   
		   //Step1: Load the db.properties file from classPath
		   InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
		   
		   //Step2: Read the properties
		   Properties prop = new Properties();
		   prop.load(input);
		   
		   //Step3: Register driver and connect
		   Class.forName(prop.getProperty("db.driver"));
		   con = DriverManager.getConnection(prop.getProperty("db.url"),
				                             prop.getProperty("db.username"),
				                             prop.getProperty("db.password"));
	   } catch(Exception e) { System.out.println(e.toString()); }
	   return con;
   }
}
