<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
<link rel="stylesheet" href="login.css">

</head>
<body>
	<ul>
	  <li><a href="index.jsp">Home</a></li>
	  <li><a class="active" href="forgetPassword.jsp">Forget Password</a></li>
	</ul>
	<form action="SendPassword" method="post">
  <div class="imgcontainer">
     <img src="Images/avtar.jpg" style="width:200px; height:'auto';" alt="Avatar" class="avatar">
     <h1>Forget Password Page</h1>
  </div>

  <div class="container">
  
    <label for="uname"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <button type="submit">Send Password To Mail</button>
    <button type="reset" class="cancelbtn">Cancel</button>
 
  </div>

  
</form>
</body>
</html>