<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/yeti/bootstrap.min.css" />
	<style>
	
	form {
	width: 30%;
	margin:0 auto;
	}
	</style>
</head>
<body>

<h1 align="center">RIDING SHOTGUN REGISTRATION FORM</h1>

<div class="container">

		<form action="" >
			<fieldset>
				<div  class="form-group" >
					<label for="fname">Enter Your First Name</label> 
					<input type="text" class="form-control" id="fname" placeholder="First Name">
			<!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
			
					<label for="lname">Enter Your Last Name</label> 
					<input type="text" class="form-control" id="lname" placeholder="Last Name"> 
			
					<label for="email">Enter Your Email</label> 
					<input type="email" class="form-control" id="email" placeholder="example@email.com">

					<label for="city">Enter Your Home City</label> 
					<input type="text" class="form-control" id="city" placeholder="City"> 
			
					<label for="username">Enter A Unique User Name</label> 
					<input type="text" class="form-control" id="userName" placeholder="User1234"> 
			
					<label for="password">Enter A Unique P@ssw0rd</label> 
					<input type="text" class="form-control" id="password" placeholder="Password">
				</div>
			</fieldset>
			<input type="submit" value="Submit">
		</form>


</div>



</body>
</html>