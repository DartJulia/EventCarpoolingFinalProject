<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="images/favicon.png">
        <title>Ride Results</title>
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

<body>

<div class="top-nav-bar" style="font-size:1.5em">
${sessionUser.first_name }
		<a href="/" style="padding: 10px">Home</a> 
			<a href="/logout" style="padding: 20px">Logout</a>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>		

<div style="margin-left: 50px; margin-right: 50px; text-align: center">

	<br>
	<h2>Rides matching your search:</h2>
	
	<br>
	<br>
	
	<form> <!--  CAN BE A REQUESTPARAM -->
				<table style="border-spacing: 20px; margin: 0 auto; width: 100%; text-align: left">
						<tr>
							<th></th>
							<th>Event title</th>
							<th>Event city</th>
							<th>State</th>
							<th>Driver Name</th>
							<th>Gender</th>
							<th>Event link</th>
							<th></th>
						</tr>
	
	
	
	<c:forEach var="ride" items="${titletag}" varStatus="count">
			<tr>	
							<th></th>
							<td>${ride.eventtitle}</td>
							<td>${ride.city}</td>
							<td>${ride.region}</td>
							
	<%-- //	<c:forEach var="driver" items="${drivers}"> --%>				
							<td>${ride.rideUser.first_name}</td>
							<td>${ride.rideUser.gender}</td>
							
							<td><a href="/joinride/${ride.rideid}/${sessionUser.user_id}">View Ride</a></td>
		
	<%-- 	</c:forEach> --%>
		
		</c:forEach>					
	
		
	
	
	</table>
	</form>
	
</div>	
</body>
</html>