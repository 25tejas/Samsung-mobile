<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
<ul>
	  <li><a href="index.jsp">Home</a></li>
	  <c:if test="${m==null}">
		  <li><a href="login.jsp">Login</a></li>
		  <li><a href="register.jsp" class="active" >Register</a></li>
	  </c:if>
	  <c:if test="${m!=null}">
	  <li><a href="ordered.jsp">Your Ordered</a></li>
	  <li><a href="cart.jsp">Cart</a></li>
	  <li><a href="login.jsp">Logout</a></li>
	  </c:if>
</ul>
<form action="Register" method="post">
  <div class="imgcontainer">
    <img src="Images/avtar.jpg" style="width:200px; height:'auto';" alt="Avatar" class="avatar">
    <h1>Register Page</h1>
  </div>

  <div class="container">
  
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

	<label for="uname"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>
	
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

	<label for="psw"><b>Confirm Password</b></label>
    <input type="password" placeholder="Enter Confirm Password" name="cpsw" required>

    <button type="submit">Register</button>
    <button type="reset" class="cancelbtn">Cancel</button>

  </div>
</form>
</body>
</html>