<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
<form action="AddMobile" enctype="multipart/form-data" method="post">
  <div class="imgcontainer">
    <img src="Images/avtar.jpg" style="width:200px; height:'auto';" alt="Avatar" class="avatar">
    <h1>Add Product Page</h1>
  </div>

  <div class="container">
  
    <label ><b>Modelno</b></label>
    <input type="text" placeholder="Enter modelno" name="modelno" required>

	<label ><b>Description</b></label>
    <input type="text" placeholder="Enter description" name="desc" required>
	
    <label ><b>Price</b></label>
    <input type="text" placeholder="Enter Price" name="price" required>

	<label ><b>Quantity</b></label>
    <input type="text" placeholder="Enter Quantity" name="qty" required>

	<label>Select File</label>
	<input type="file" name="image" placeholder="Select image" class="form-control"/>
	</div>
    <button type="submit">Add Product</button>
    <button type="reset" class="cancelbtn">Cancel</button>

  </div>
</form>
</body>
</html>