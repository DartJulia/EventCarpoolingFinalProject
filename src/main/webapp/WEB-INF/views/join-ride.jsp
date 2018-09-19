<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet"
	href="https://bootswatch.com/4/lux/bootstrap.min.css" /> 
<link href="css/style.css" rel="stylesheet">

<style>

.top-nav-bar {
    right: 60px;
    position: absolute;
    top: 45px;
    z-index: 99999;

}
</style>

</head>
<body style="background-color:	#D3D3D3">

<div class="top-nav-bar" style="font-size:1.5em">

		${sessionUser.first_name }
		<a href="/" style="padding: 10px">Home</a> 
			<a href="/logout" style="padding: 20px">Logout</a>
</div>

<div style="margin-left: 50px; margin-right: 50px; text-align: center; margin-top: 100px;">

<h1> join ride with ${drivername} to ${title}? </h1>
<br>
<h2> Seats available: ${seats} </h2><br>
<h2>Cost for one: $${cost} </h2><br>
<h2>Cost for two: $${costfor2} </h2><br>
<h2>Cost for three: $${costfor3}</h2>
<br>
<br>
<br>
<form action="/saveride/${riderevent}/${sessionUser.user_id}"> 

			<h3><input type="radio" value="round" name="trip"> Round Trip
			<input type="radio" value="one" name="trip"> One Way</h3>
<br>
<br>

			<button style="border-radius: 6px" class="btn btn-info">Join Ride</button>
</form> 
<br>

<a href="/"><button style="border-radius: 6px" class="btn btn-info">No Thanks</button></a>
</div>


</body>
</html>