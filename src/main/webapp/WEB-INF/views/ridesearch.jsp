<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ride Search</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />

<script src="search.js"></script>


</head>
<body>


<h3>Search Available Rides by City:</h3>
<form action="/rideresults" id> 
<input type="text" style="font-size: 150%; width: 350px"
							name="query"  placeholder="What city are you searching in?">

<input type="submit" value="Find an Event">
</form>
<!-- <form action="/rideresults"> 
<input type="text" style="font-size: 150%; width: 350px"
							name="query"  placeholder="What state are you searching in?">

<input type="submit" value="Find an Event">
</form>
<form action="/rideresults"> 
<input type="text" style="font-size: 150%; width: 350px"
							name="query"  placeholder="What event are interested in?">

<input type="submit" value="Find an Event">
</form> -->
	<!-- 
		
	
	<!-- 	<table style="border-spacing: 20px; margin: 0 auto; width: 75%">	
					<tr>
					
						<td>search by city</td>
						<td><input type="text" style="font-size: 150%; width: 350px"
							name="query"  placeholder="what city are you searching in?"></td>
					</tr> -->
	<!-- <tr>
						<td>search by state</td>
						<td><input type="text" style="font-size: 150%; width: 350px"
							name="query" value="querystate" placeholder="what state are you searching in?"></td>
					</tr>
					<tr>
						<td>search by event title</td>
						<td><input type="text" style="font-size: 150%; width: 350px"
							name="query" value="querytitle" placeholder="what is the name of your event?"></td>
					</tr> -->

	<!-- 		</table> -->
	<br>
	<!-- 	<input type="submit" value="Find an Event"> -->
	<!-- 	</form> -->
<!-- 	<input id="city" type="radio" name="query" value="city">
<label>Search by City</label><br>
<input id="state" type="radio" name="query" value="state">
<label>Search by State</label><br>
	<input id="title" type="radio" name="query" value="title">
<label>Search by Event Keyword</label><br>

<input type="text" id="oneSearch" name="query" placeholder="Search"><br>
<input type="submit" value="Find an Event">  -->

</body>
</html>