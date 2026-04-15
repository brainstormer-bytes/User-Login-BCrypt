<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.User"%>
<%
response.setHeader("Cache-Control" , "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
//  Check if already logged in FIRST, before anything else
if(session.getAttribute("userEmail") != null) {
    response.sendRedirect("index.jsp");
    return; // stop further execution of this page
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
   <h2><b>Login</b></h2>
    <br>
    <div>
      <form action = "LoginServlet" method = "post">
        <label for = "email2">Email : </label>
        <input type = "email" name = "email" id = "email2" placeholder = "Confirm email" required><br><br>
        <label for = "password2">Password : </label>
        <input type = "password" name = "password" id = "password2" placeholder = "Confirm password" required><br><br>
        <button type = "submit">Submit</button>
      </form>
    </div>
</body>
 <footer>
 <pre> Haven't created an account? <a href = "register.jsp">Register Here</a>  </pre>
 </footer>
</html>