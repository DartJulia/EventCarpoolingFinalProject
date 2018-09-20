<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/lux/bootstrap.min.css" />
</head>
<body style="background-color:	#D3D3D3">
<div class="top-nav-bar" style="text-align: right">

	${sessionUser.first_name}
	<a href="/" style="padding: 20px">Home</a>
	<a href="/logout" style="padding: 20px">logout</a>

</div>

<div style="margin-top: 50px; text-align: center">
<h2 style="color:#227cc6">Your Event: ${title}</h2>
<br>
<h3>Suggested Gas Share:</h3>
<h4>Potential gas savings with 1 rider: $${cost}</h4>
<h4>Potential gas savings with 2 riders: $${costfor2}</h4>
<h4>Potential gas savings with 3 riders: $${costfor3}</h4>

<div style="margin-left: 50px; margin-top: 50px;">

<%-- <h4><a href="${echosen.url}" target="blank">Click for Event Details</a></h4> --%>

<br>
<h4>Drive to this event?</h4>
<br>
<a href="/registerdriver/${echosen.id}/${echosen.title}/${sessionUser.user_id}/${echosen.city_name}/${echosen.region_name}/${echosen.latitude}/${echosen.longitude}"><button style="border-radius: 6px" class="btn btn-info">Yes!</button></a>
<a href="/"><button style="border-radius: 6px"class="btn btn-info">Cancel</button></a>

<br>
<br>	

<%-- <h3>Price: ${price}</h3> --%>
<!-- <iframe width="600" height="450" frameborder="0" style="border:0"> -->
<%-- <iframe><src="https://www.google.com/maps/embed/v1/search?q="${latit},${longit}&key=${mapkey}" allowfullscreen"></iframe> --%>
<iframe width="600" height="450" frameborder="0" style="border:0"
src="https://www.google.com/maps/embed/v1/search?q=${latit},${longit}&key=${mapkey}" allowfullscreen></iframe> 

	
</div>

</div>
</body>
</html>