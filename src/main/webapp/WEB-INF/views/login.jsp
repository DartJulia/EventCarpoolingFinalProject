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
	width: 30%;
	margin: 0 auto;
}

</style>


</head>
<body>

	<div class="top-nav-bar" style="font-size:1.5em">

	<a href="/" style="padding: 30px">Home</a>

	</div>

	<h1 align="center">RIDING SHOTGUN LOGIN</h1>

	<div class="container">

		<form action="validateuser" method= "post">

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