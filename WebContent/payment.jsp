<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>
<div id="accordion">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h5 class="mb-0">
        <input type="radio" id="r" name="r" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Cash on delivery
       
      </h5>
    </div>

    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
      <div class="card-body">
      <form class="form" action="ValidatePayment">
      		<input type="hidden" name="cid" value="${param.cid}"required>
        	Paid the payment on delivery<button type="submit" class="btn btn-primary">Proceed</button>
        	</form>
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h5 class="mb-0">
        <input type="radio" id="r" name="r" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Card Payment
      </h5>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
      <div class="card-body">
        <form class="form" action="ValidatePayment">
        <div class="form-group">
        	
		    <input type="hidden" name="cid" value="${param.cid}"required>
		  </div>
          <div class="form-group">
        	<label ><b>Card Number:</b></label>
		    <input type="number" placeholder="Enter Card Number"  name="cardno" class="form-control"required>
		  </div>
		  
		  <div class="form-group">
			<label ><b>Expiry Date:</b></label>
		    <input type="date" placeholder="Enter Expiry Date" name="expdate"class="form-control" required>
		  </div>
		  
		  <div class="form-group">
		    <label><b>CVV:</b></label>
		    <input type="number" placeholder="Enter Password" name="cvv" min="100" max="999" class="form-control"required >
		   </div>
		   
		  <div class="form-group">
		    <button type="submit" class="btn btn-primary">Proceed</button>
		    <button type="reset" class="btn btn-danger">Reset</button>
		    </div>
        </form>
      </div>
    </div>
  </div>
  
</div>
</body>
</html>