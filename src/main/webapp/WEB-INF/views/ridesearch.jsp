<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ride Search</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>


<form action="/rideresults">
		<table style="border-spacing: 20px; margin: 0 auto; width: 75%">
					
					<tr>
						<td>search by city</td>
						<td><input type="text" style="font-size: 150%; width: 350px"
							name="querycity" placeholder="what city are you searching in?"></td>
					</tr>
					<tr>
						<td>search by state</td>
						<td><input type="text" style="font-size: 150%; width: 350px"
							name="querystate" placeholder="what state are you searching in?"></td>
					</tr>
					<tr>
						<td>search by event title</td>
						<td><input type="text" style="font-size: 150%; width: 350px"
							name="querytitle" placeholder="what is the name of your event?"></td>
					</tr>
					
				</table>
				<br>
				<input type="submit" value="Find an Event">
	</form>


</body>
</html>