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

		<form action="/adduser">
			
				<div  class="form-group" >
					<label>Enter Your First Name</label> 
					<input type="text" class="form-control" name="first_name" placeholder="First Name">
			<!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
			
					<label>Enter Your Last Name</label> 
					<input type="text" class="form-control" name="last_name" placeholder="Last Name"> 
			
					<label>Enter Your Email</label> 
					<input type="email" class="form-control" name="email" placeholder="example@email.com">

					<label>Enter Your Home City</label> 
					<input type="text" class="form-control" name="address" placeholder="City"> 
			
					<label>Enter A Unique User Name</label> 
					<input type="text" class="form-control" name="username" placeholder="User1234"> 
			
					<label>Enter A Unique P@ssw0rd</label> 
					<input type="password" class="form-control" name="passcode" placeholder="Password">
				</div>
			
			<%-- <a href="/adduser/${first_name}/${last_name}/${email}/${address}/${username}/${passcode}"><button>Submit</button></a> --%>
			  <input type="submit" value="Submit"> 
		</form>


</div>



</body>
</html>