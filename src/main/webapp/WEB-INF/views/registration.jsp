<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/yeti/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="test2.css">
	<script src="jquery-3.3.1.min.js"></script>
<script src="registration.js"></script>

<style>
form {
	width: 50%;
	margin: 0 auto;
}

</style>


</head>
<body>

	<h1 align="center">RIDING SHOTGUN REGISTRATION FORM</h1>

	<div class="container">

		<form action="/adduser">

			<div class="form-group">
				<label>Enter Your First Name</label> <input type="text"
					class="form-control" name="first_name" placeholder="First Name">
				<!-- if name = POJO variable names, don't need to use RequestParam or PathVariable; pass in User object on controller side-->
				<label>Enter Your Last Name</label> <input type="text"
					class="form-control" name="last_name" placeholder="Last Name">
					
					<label>Select Gender</label> <br>
					<label>Male</label>
					<input type="radio" name="gender" value="Male">
					<label>Female</label>
					<input type="radio"  name="gender" value="Female">
					

				<br>
				<label>Enter Your Email</label> <input type="email"
					class="form-control" name="email" placeholder="example@email.com">

				<label>Enter Your Home City</label> <input type="text"
					class="form-control" name="address" placeholder="City"> <label>Enter
					A Unique User Name</label> <input type="text" class="form-control"
					name="username" placeholder="User1234"> <label>Enter
					A Unique P@ssw0rd</label> <input type="password" class="form-control"
					name="passcode" placeholder="Password">
				
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