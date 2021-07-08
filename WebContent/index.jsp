<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Products </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="login.css">
<style type="text/css">
.active {
  background-color: #4CAF50;
}
</style>
<body>
<ul>
	  <li><a class="active" href="index.jsp">Home</a></li>
	  <c:if test="${m==null}">
		  <li><a href="login.jsp">Login</a></li>
		  <li><a href="register.jsp">Register</a></li>
	  </c:if>
	  <c:if test="${m!=null}">
	  <li><a href="ordered.jsp">Your Ordered</a></li>
	  <li><a href="cart.jsp">Cart</a></li>
	  <li><a href="login.jsp">Logout</a></li>
	  </c:if>
	</ul>
	

		<sql:setDataSource driver="com.mysql.jdbc.Driver"
						   url="jdbc:mysql://localhost:3306/ecommerce"
						   user="root"
						   password="root"
						   var="con"/>
			
		
				
		<sql:query var="rs" dataSource="${con}">
			select * from mobile
		</sql:query>
			

		<c:forEach items="${rs.rows}" var="row">
		<div class="w3-container">
		  <div class="w3-card-2" style="width:90% " >
		    <div class="w3-container" > 
		      <img src="Images/abc.jpg" class="w3-left w3-margin-right" style="width:auto; height:300px;">
		      <h2>${row.name}</h2>
		      <h2>${row.modelno}</h2>
		      <p>${row.description }</p>
		      <h3>Rs.${row.price}</h3>
		      <a href="AddToCart?id=${row.mid}&pr=${row.price}""><button class="w3-button w3 w3-dark-grey">Add To Cart</button></a>
		    </div>
		  </div>
		</div>
		</c:forEach> 
</body>
</html>
