<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<div class="container" style="margin: 50px">

	<div class="logins" style="text-align: right">
		<a href="/" style="padding: 20px">sign up</a>
		<a href="/" style="padding: 20px">login</a>
	</div>
	
	<br>
	
	<div>
	<h1 style="text-align: center; font-size: 100px">I CALL SHOTGUN!</h1>
	<p style="text-align: center; font-size: 150%">find rides to events nationwide</p>
	</div>
	
	<br>
	
		<table style="border-spacing: 20px; margin: 0 auto; width: 75%">
				<tr>
				<form action="/searchloc">
				<td>search by location</td>
				<td><input type="text" style="font-size: 150%" name="queryloc" placeholder="where would you like to go?"></td>
				<td><input type="submit"></td>
				</form>
				</tr>
				<br>
				
				<tr>
				<form action="/searchname">
				<td>search by keyword</td>
				<td><input type="text" style="font-size: 150%" name="queryname" placeholder="what is your event keyword?"></td>
				<td><input type="submit"></td>
				</form>
				</tr>
				<br>
				
				<tr>
				<form action="/searchdate">
				<td>search by date</td>
				<td><input type="text" style="font-size: 150%" name="querydate" placeholder="when is your event?"></td>
				<td><input type="submit"></td>
				</form>
				</tr>
				<br>
				
		</table>
		<br>
	<br>

</div>	

</body>
</html>