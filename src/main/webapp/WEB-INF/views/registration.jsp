<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="images/favicon.png">
        <title>I Call Shotgun</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/custom.js" type="text/javascript"></script>
        <link rel="stylesheet" href="jobotest.css" type="text/css"> 
    </head>
<style>
form {
	width: 50%;
	margin: 0 auto;
}

</style>


</head>
<body>

<div class="top-nav-bar" style="font-size:1.5em">

<a href="/" style="padding: 30px">Home</a>

</div>
	<h1 align="center">RIDING SHOTGUN REGISTRATION FORM</h1>

	<div class="container">

		<form action="/adduser" onsubmit="validate()" method= "post"> 

			<div class="form-group">
				<label>Enter Your First Name</label> <input type="text"
					class="form-control" name="first_name" placeholder="First Name" required>
				<!-- if name = POJO variable names, don't need to use RequestParam or PathVariable; pass in User object on controller side-->
				<label>Enter Your Last Name</label> <input type="text"
					class="form-control" name="last_name" placeholder="Last Name" required>
					
					<label>Select Gender</label> <br>
					<label>Male</label>
					<input type="radio" name="gender" value="Male">
					<label>Female</label>
					<input type="radio"  name="gender" value="Female">
					

				<br>
				<label>Enter Your Email</label> <input type="email" class="form-control" name="email" placeholder="example@email.com" required>
				<label>Enter Your Zip Code</label> 
				<input type="text" class="form-control" name="address" placeholder="Zip" required> 
				<label>Enter A Unique User Name</label> 
				<input type="text" class="form-control" name="username" placeholder="User1234" required> 
				<label>Enter A Unique P@ssw0rd</label> 
				<input type="password" class="form-control" name="passcode" placeholder="Password" required>
				
				<h1>OPTIONAL CAR INFO:</h1>
				<p>leave blank if not applicable</p>
			<!-- 	car info	 -->
				<label>Enter Your Car Type (SUV or sedan):</label> <input type="text"
					class="form-control" name="car_type" placeholder="Car Type">
				<!-- if name = POJO variable names, don't need to use RequestParam or PathVariable; pass in User object on controller side-->
				<label>Enter your car's total number of seats:</label> <input type="number"
					class="form-control" name="seats" placeholder="Seats">

				<label>Enter Your License Plate Number</label> <input type="text"
					class="form-control" name="plate" placeholder="Plate Number">
						
			</div>

			<input type="submit" value="Submit">
		</form>


	</div>


${welcome}
</body>
</html>