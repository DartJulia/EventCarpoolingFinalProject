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
	
	<style>
	img {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 40%;
	}
	
	.card border-primary mb-3 {
	display: inline-block;
	float: left;
	margin-right: 10px;
	}
	
	</style>
</head>
<body>



<div class="container" style="margin: 20px">

	
		<h1>YOU SEARCHED FOR ${queryloc} ${queryname} ${querydate}</h1>
		
		<form> <!--  CAN BE A REQUESTPARAM -->
			<!-- <table style="border-spacing: 20px; margin: 0 auto; width: 100%"> -->
			<!-- 		<tr>
						<th></th>
						<th>date/time</th>
						<th>event</th>
						<th>select</th>
						<th>Driver ? </th>
					</tr>-->	
		
				<c:forEach var="event" items="${events}">	
					<div style="max-width: 20rem; display: inline-block;  float: left;  margin-right: 10px; height: 300px; text-overflow: ellipsis;">
				<div class="card border-primary mb-3" >
				<div class="card-header"><a href="/event/${event.id}/${event.title}/${event.start_time}/${event.venue_name}/${event.latitude}/${event.longitude}">${event.title }</a></div>
				<div class="card-body">
				   <h4 class="card-title"><img src="${event.image.thumb.url}"></h4>
				   <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				 </div>
				 </div>
				</div>
				</c:forEach>
			<!-- </table> -->
			<br>
		</form>
	</div>

</div>

</body>
</html>