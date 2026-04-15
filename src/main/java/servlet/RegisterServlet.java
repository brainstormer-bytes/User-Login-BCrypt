package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;
import model.User;
import dao.UserDAO;


public class RegisterServlet extends HttpServlet {
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		User u = new User();
		UserDAO ud = new UserDAO();
		
		// BCrypting or Hashing the password
		String rawPassword = request.getParameter("password");      //make sure the name = "password"
		String BcryptPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
		
		
		
		u.setName(request.getParameter("username"));      //make sure the name = "username"
		u.setEmail(request.getParameter("email"));        //make sure the name = "email"
		
		ud.addUserdetails(u.getName(), u.getEmail(), BcryptPassword);  //storing the user data to Database
		u.setPassword(BcryptPassword);  
		
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}
