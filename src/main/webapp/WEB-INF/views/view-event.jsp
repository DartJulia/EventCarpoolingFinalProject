<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<div style="margin-left: 50px; margin-top: 50px;">

<h1> Rides going to event: </h1>

<h4>Latitude: ${latit} </h4>
<h4>Longitude: ${longit} </h4>
<a href="/gasprice">Calculate gas price</a>
<h3>Price: ${price}</h3>
<iframe width="600" height="450" frameborder="0" style="border:0"
src="https://www.google.com/maps/embed/v1/search?q=${latit},${longit}&key=AIzaSyAKfsn7d9hrGFAZ8li6w5Fncn-sV0xSlJI" allowfullscreen></iframe>

</div>

</body>
</html>