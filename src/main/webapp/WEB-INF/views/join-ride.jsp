<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
	
</head>
<body>
<div class="container" style="margin: 50px">

<h1> ${ridername} is riding with ${drivername} to ${title} </h1>
<br>
${cost} <br>
${costfor2} <br>
${costfor3}
<br>
<form action="/saveride/${riderevent}/${sessionUser.user_id}"> 

			<input type="radio" value="round" name="trip">Round Trip
			<input type="radio" value="one" name="trip">One Way
<br>
			<input type="submit" value="Join Ride">
</form> 
<br>

<a href="/"><button>Search again</button></a>
</div>


</body>
</html>