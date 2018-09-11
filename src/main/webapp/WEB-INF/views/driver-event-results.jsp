<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Events</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<div class="container" style="margin: 50px">

	<div style="margin-left: 50px; margin-top: 50px;">
		<h1>YOU SEARCHED FOR ${queryloc} ${queryname} ${querydate}</h1>
		
		<form> <!--  CAN BE A REQUESTPARAM -->
			<table style="border-spacing: 20px; margin: 0 auto; width: 100%">
					<tr>
						<th></th>
						<th>date/time</th>
						<th>event</th>
						<th>select</th>
						<th>Driver ? </th>
					</tr>
					
				<c:forEach var="event" items="${events}">	<!--prints from ArrayList in controller-->	
					<tr>
						<td><%-- <img src="${event.image}" alt="no image available" style="width:128px;height:128px;"> --%></td>
						<td>${event.start_time}</td>
						<td>${event.title}</td>
						<%-- <td><a href="/event/${event.latitude}/${event.longitude}">view</a></td> --%>
						<td><a href="/event/${event.id}/${event.title}/${event.start_time}/${event.venue_name}/${event.latitude}/${event.longitude}">view</a></td>
						<td><a href="/pullevent/{id}/{title}">Yes</a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
		</form>
	</div>

</div>

</body>
</html>