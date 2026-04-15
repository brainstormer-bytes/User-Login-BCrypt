package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.PreparedStatement;
import db.DBConnection;
import model.User;

public class UserDAO {
	
	
    public void addUserdetails(String userName, String userEmail, String userPass) {
    	try {
    		DBConnection dbc = new DBConnection();
    		Connection con = dbc.connect();
    	  String query = "Insert Into user_info (username,email,password_hash) Values (?,?,?)";
    	  PreparedStatement st = con.prepareStatement(query);
    	  st.setString(1, userName);
    	  st.setString(2, userEmail);
    	  st.setString(3, userPass);
    	  int count = st.executeUpdate();
    	  System.out.println(count + " row/s affected");
    	  st.close();
    	  con.close();
    	} catch (Exception e) { System.out.println(e.toString()); }
    }
    public User checkUserdetails(String userEmail, String userPass) {
    	User u = new User();	
    	try {
    		DBConnection dbc = new DBConnection();
    		Connection con = dbc.connect();
    	  String query = "Select * From user_info Where email = ?;";
    	  PreparedStatement st = con.prepareStatement(query);
    	  st.setString(1, userEmail);
    	  ResultSet rs = st.executeQuery();
    	  rs.next();
    	  if(BCrypt.checkpw(userPass, rs.getString("password_hash"))) {
    		   u.setName(rs.getString("username"));
    		   u.setEmail(rs.getString("email"));
    		   u.setPassword(rs.getString("password_hash"));
    	  }
    	  st.close();
    	  rs.close();
    	  con.close();
    	} catch (Exception e) { System.out.println(e.toString()); }
    	return u;
    }
}