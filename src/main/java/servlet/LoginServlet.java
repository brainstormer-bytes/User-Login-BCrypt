package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import model.User;
import dao.UserDAO;


public class LoginServlet extends HttpServlet {
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		UserDAO ud1 = new UserDAO();
		User u = ud1.checkUserdetails(email,password);
		
		if(u.getEmail() != null && email.equals(u.getEmail())) {
		    HttpSession session = request.getSession();
		    session.setAttribute("userEmail", u.getEmail());
		    session.setAttribute("username", u.getName());
		
		    response.sendRedirect("index.jsp");
		   
		} else {
			response.sendRedirect("login.jsp");
		
		}
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
