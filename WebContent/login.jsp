<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="login.css">

</head>
<body>
			<%
			session.removeAttribute("m");
    		session.invalidate();
			%>
	<ul>
	
	  <li><a href="index.jsp">Home</a></li>
	  <c:if test="${m==null}">
		  <li><a class="active" href="login.jsp">Login</a></li>
		  <li><a href="register.jsp">Register</a></li>
	  </c:if>
	  <c:if test="${m!=null}">
	  <li><a href="ordered.jsp">Your Ordered</a></li>
	  <li><a href="cart.jsp">Cart</a></li>
	  <li><a href="login.jsp">Logout</a></li>
	  </c:if>
	  
	</ul>
	<form action="Login" method="post">
  <div class="imgcontainer">
     <img src="Images/avtar.jpg" style="width:200px; height:'auto';" alt="Avatar" class="avatar">
     <h1>Login Page</h1>
  </div>

  <div class="container">
  
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
    
	<span class="psw">Forgot <a href="forgetPassword.jsp">password?</a></span>
   
    <button type="submit">Login</button>
    <button type="reset" class="cancelbtn">Cancel</button>
 
  </div>

  
</form>
</body>
</html>