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
			<a href="/registerpage" style="padding: 20px">sign up</a> <a href="/"
				style="padding: 20px">login</a>
		</div>

		<br>

		<div align="center">
			<h1 style="text-align: center; font-size: 100px">I CALL SHOTGUN!</h1>
			<p style="text-align: center; font-size: 150%">find rides to
				events nationwide</p>

			<br>

			<form name="searchform" action="/allsearch">
			
			<label class="switch">
				<input class="switch-input" type="checkbox" id="rideordrive" value="yes">
				<span class="switch-label" data-on="Rider" data-off="Driver"></span> 
				<span class="switch-handle"></span> 
			</label>
				
				<!-- <div class="toggle">
					<label> rider or driver? </label> 
					<label class="switch"> 
					<input type="checkbox" id="rideordrive" value="yes" data-label-off="rider" data-label-on="driver"> <span class="slider round"></span>
					</label>
				</div> -->

				<table style="border-spacing: 20px; margin: 0 auto; width: 75%">
					<tr>
						<td>search by location</td>
						<td><input type="text" style="font-size: 150%"
							name="queryloc" placeholder="where would you like to go?"></td>
					</tr>
					<tr>
						<td>search by keyword</td>
						<td><input type="text" style="font-size: 150%"
							name="queryname" placeholder="what is your event keyword?"></td>
					</tr>
					<tr>
						<td>search by date</td>
						<td><input type="text" style="font-size: 150%"
							name="querydate" placeholder="when is your event?"></td>
					</tr>
				</table>
				<input type="submit" value="search">
			</form>
		</div>
</div>
	
<script src="index.js"></script>

</body>
</html>