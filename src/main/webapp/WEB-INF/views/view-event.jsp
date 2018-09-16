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

<!-- <a href="/calcrideprice"><button>Get Cost</button></a> -->
<div class="jumbotron">
<h2>${title}</h2>
<h3>Total Price of Trip: $${cost}</h3>
<h3>Price with 2 riders: $${costfor2}</h3>
<h3>Price with 3 riders: $${costfor3}</h3>

<div style="margin-left: 50px; margin-top: 50px;">


<%-- <h4>Latitude: ${latit} </h4>
<h4>Longitude: ${longit} </h4> --%>

<h4>${gaspricefor2}</h4>
<h4>${gaspricefor3}</h4>
<a href="${event.url}" target="blank">Event Link</a>
<%-- <h3>Price: ${price}</h3> --%>
<!-- <iframe width="600" height="450" frameborder="0" style="border:0"> -->
<%-- src="https://www.google.com/maps/embed/v1/search?q=${latit},${longit}&key=${maps.key} allowfullscreen></iframe> --%>
<br>
	<a href="/registerdriver/${echosen.id}/${echosen.title}/${sessionUser.user_id}/${echosen.city_name}/${echosen.region_name}/${echosen.latitude}/${echosen.longitude}">Submit</a>
		<a href="/">Cancel</a>

</div>

</div>
</body>
</html>