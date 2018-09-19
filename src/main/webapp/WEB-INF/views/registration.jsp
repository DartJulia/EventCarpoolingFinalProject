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
<body style="background-color:	#D3D3D3">

<div class="top-nav-bar" style="font-size:1.5em">

		<a href="/" style="padding: 10px">Home</a> 
		<a href="/login" style="padding: 20px">login</a>
			
</div>
<div style="margin-left: 50px; margin-right: 50px; text-align: center">
<br>
<br>
	<div style="margin-top: 100px">
		<h1 style="text-align: center">New User Registration</h1>
	</div>
<br>
<br>
	<div class="container">

		<form action="/adduser" onsubmit="validate()" method= "post"> 

			<div class="form-group">
				<label style="font-size:15px">Enter Your First Name</label> <input type="text"
					class="form-control" name="first_name" placeholder="First Name" required><br>
				<!-- if name = POJO variable names, don't need to use RequestParam or PathVariable; pass in User object on controller side-->
				<label style="font-size:15px">Enter Your Last Name</label> <input type="text"
					class="form-control" name="last_name" placeholder="Last Name" required><br>
					
					<label style="font-size:15px">Select Gender</label> <br>
					<label style="padding:5px">Male</label>
					<input type="radio" name="gender" value="Male">
					<label>Female</label>
					<input type="radio"  name="gender" value="Female"><br>
					

				<br>
				<label style="font-size:15px">Enter Your Email</label> <input type="email" class="form-control" name="email" placeholder="example@email.com" required><br>
				<label style="font-size:15px">Enter Your Zip Code</label> 
				<input type="text" class="form-control" name="address" placeholder="Zip" required> <br>
				<label style="font-size:15px">Enter A Unique User Name</label> 
				<input type="text" class="form-control" name="username" placeholder="User1234" required> <br>
				<label style="font-size:15px">Enter A Unique P@ssw0rd</label> 
				<input type="password" class="form-control" name="passcode" placeholder="Password" required><br>
				
				<h1>OPTIONAL CAR INFO:</h1><br>
				<p>*Leave blank if not applicable*</p><br>
			<!-- 	car info	 -->
				<label style="font-size:15px">Enter Your Car Type (SUV or sedan):</label> <input type="text"
					class="form-control" name="car_type" placeholder="Car Type"><br>
				<!-- if name = POJO variable names, don't need to use RequestParam or PathVariable; pass in User object on controller side-->
				<label style="font-size:15px">Enter your car's total number of seats:</label> <input type="number"
					class="form-control" name="seats" placeholder="Seats"><br>

				<label style="font-size:15px">Enter Your License Plate Number</label> <input type="text"
					class="form-control" name="plate" placeholder="Plate Number"><br>
						
			</div>
<button class="btn-primary">Submit</button>
<br>
<br>
		
		</form>


	</div>

</body>
</html>