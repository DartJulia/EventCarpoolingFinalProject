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

<!-- <a href="/calcrideprice"><button>Get Cost</button></a> -->
<div style="margin-top: 50px; text-align: center">
<h2 style="color:#227cc6">${title}</h2>
<br>
<h3>Suggested Gas Share:</h3>
<h3>Price with 1 rider: $${cost}</h3>
<h3>Price with 2 riders: $${costfor2}</h3>
<h3>Price with 3 riders: $${costfor3}</h3>

<div style="margin-left: 50px; margin-top: 50px;">

<h4><a href="${event.url}" target="blank">Click for Event Details</a></h4>

<br>
<br>
<a href="/registerdriver/${echosen.id}/${echosen.title}/${sessionUser.user_id}/${echosen.city_name}/${echosen.region_name}/${echosen.latitude}/${echosen.longitude}"><button style="border-radius: 6px" class="btn btn-info">Submit</button></a>
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