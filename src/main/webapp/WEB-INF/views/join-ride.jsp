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

<h1 style="color:#227cc6"> join ride with ${drivername} to ${title}? </h1>
<br>
<h3> Seats available in ${drivername}'s car: ${seats} </h3><br>
<br>
<h3 style="color:#227cc6">Suggested donation to your driver</h3>
<h3>With one rider: $${cost} </h3><br>
<h3>With two riders: $${costfor2} </h3><br>
<h3>With three riders: $${costfor3}</h3>
<br>
<h5 style="color:#227cc6">The more riders, the more affordable it is for everyone!</h5>
<br>
<br>
<form action="/saveride/${riderevent}/${sessionUser.user_id}"> 

			<h3><input type="radio" value="round" name="trip" required> Round Trip
			<input type="radio" value="one" name="trip"> One Way</h3>
<br>
<br>

			<button style="border-radius: 6px" class="btn btn-info">Join Ride</button>
</form> 
<br>

<a href="/"><button style="border-radius: 6px" class="btn btn-info">No Thanks</button></a>
</div>
<br>
<br>

</body>
</html>