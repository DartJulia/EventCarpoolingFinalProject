<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />

<link rel="stylesheet" href="jobotest.css" type="text/css">

</head>
<body>

	<div class="container" style="margin: 50px">

		<div class="logins" style="text-align: right">
		${welcome}
		${sessionUser.first_name }
			<a href="/registerpage" style="padding: 20px">sign up</a> 
			<a href="/login" style="padding: 20px">login</a>
			<a href="/logout" style="padding: 20px">logout</a>
		</div>

		<br>

		<div align="center">
			<h1 style="text-align: center; font-size: 100px">I CALL SHOTGUN!</h1>
			<p style="text-align: center; font-size: 150%">find rides to
				events nationwide</p>

			<br>

			<form name="searchform" action="/ridesearch">
			
			<label class="switch">
				<input class="switch-input" type="checkbox" id="rideordrive" value="yes" checked="false">
				<span class="switch-label" data-on="Rider" data-off="Driver"></span> 
				<span class="switch-handle"></span> 
			</label>
			<input type="submit" value="Find">
				
				<!-- <div class="toggle">
					<label> rider or driver? </label> 
					<label class="switch"> 
					<input type="checkbox" id="rideordrive" value="yes" data-label-off="rider" data-label-on="driver"> <span class="slider round"></span>
					</label>
				</div> -->

				
			</form>
		</div>
</div>
	
<script src="index.js"></script>

</body>
</html>