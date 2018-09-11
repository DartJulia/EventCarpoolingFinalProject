<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/yeti/bootstrap.min.css" />
	<script src="jquery-3.3.1.min.js"></script>
<script src="registration.js"></script>
<style>
form {
	width: 30%;
	margin: 0 auto;
}

</style>


</head>
<body>

	<h1 align="center">RIDING SHOTGUN LOGIN</h1>

	<div class="container">

		<form action="login">

			<div class="form-group">
				<label>USER NAME</label> <input type="text"
					class="form-control" name="user_name" placeholder="UserName">
				<!-- if name = POJO variable names, don't need to use RequestParam or PathVariable; pass in User object on controller side-->
				<label>PASSWORD</label> <input type="password"
					class="form-control" name="password" placeholder="P@$$W0rd">
			</div>

			<input type="submit" value="Submit">
		</form>


	</div>



</body>
</html>