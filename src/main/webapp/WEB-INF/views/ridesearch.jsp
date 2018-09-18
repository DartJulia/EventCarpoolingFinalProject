<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="images/favicon.png">
        <title>Ride Search</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/custom.js" type="text/javascript"></script>
        <link rel="stylesheet" href="jobotest.css" type="text/css"> 
        
        <style>
        a { color: #000000; } 
		a:hover { color: #00FF00; } /* CSS link hover (green) */
        </style>

</head>
<body style="background-color:	#D3D3D3">

<div class="top-nav-bar" style="font-size:1.5em">
${sessionUser.first_name }
		<a href="/" style="padding: 10px">Home</a> 
			<a href="/logout" style="padding: 20px">Logout</a>
</div>
<div style="margin-left: 50px; margin-right: 50px; text-align: center">

	
	
	<div style="margin-top: 160px">
		<h1 style="text-align: center">SEARCH AVAILABLE RIDES BY CITY</h1>
	</div>
	
	
	<form style="align: center" action="/rideresults"> 
	<div style="margin-top: 160px">
		<input type="text" style="font-size: 150%; width: 350px; padding: 10px"
									name="query"  placeholder="What city are you searching in?">
	</div>


	<!-- <input type="submit" value="Find an Event"> -->
	<div style="margin-top: 100px">
		<button class="btn-primary">Find Rides</button>
	</div>
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
</div>
</body>
</html>