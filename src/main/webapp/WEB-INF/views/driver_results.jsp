<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <link rel="stylesheet"
	href="https://bootswatch.com/4/lux/bootstrap.min.css" /> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="images/favicon.png">
        <title>I Call Shotgun</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/custom.js" type="text/javascript"></script>

<!-- 
	
	<style>
	img {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 60%;
	}
	
	.card border-primary mb-3 {
	display: inline-block;
	float: left;
	margin-right: 10px;
	}
	
	</style> -->
</head>
<body style="margin:10px;text-align:center; background-color:#D3D3D3">

<div class="top-nav-bar" style="font-size:1.5em">
	
			<a href="/" style="padding: 10px">Home</a> 
			<a href="/logout" style="padding: 10px">Logout</a>
			</div>
<br>
<br>
<br><br><br><br>
<div style="margin: 20px">

	
		<h1 style="text-align:center; font-size:50px; color:#227cc6">YOU SEARCHED FOR ${queryloc} ${queryname} ${querydate}</h1>
		<br>
		<br>
		<br>
		
		
		<form style="margin-left:70px"> <!--  CAN BE A REQUESTPARAM -->
			<!-- <table style="border-spacing: 20px; margin: 0 auto; width: 100%"> -->
			<!-- 		<tr>
						<th></th>
						<th>date/time</th>
						<th>event</th>
						<th>select</th>
						<th>Driver ? </th>
					</tr>-->	
		
				<c:forEach var="event" items="${events}">	
					<div style="max-width: 20rem; display: flex;  float: left;  maargin-left:10px;margin-right: 10px; height: 400px; text-overflow: ellipsis; text-align:center">
				<div class="card border-info mb-3" >
				<div class="card-header"><a href="/event/${event.id}/${event.title}/${event.start_time}/${event.venue_name}/${event.latitude}/${event.longitude}/${event.city_name}/${event.region_name}">${event.title}</a></div>
				<div class="card-body">
				   <h3 class="card-title"><img src="${event.image.medium.url}" onerror="this.src='https://www.europapark.de/sites/default/files/styles/teaser-promo/public/field_hero_slideshow/event/live_on_stage_2018_europa-park.jpg?itok=fGLg6SJy'"  style="width:180px;height:180px"></h3>
				  <a href="${event.url}" target="blank">event link</a>
				   <p class="card-text">${event.start_time}</p>
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