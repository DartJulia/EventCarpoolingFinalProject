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
	<link rel="stylesheet" href="jobotest.css" type="text/css">
</head>
<body>
<div class="container" style="margin: 50px">

<h1> ${user} is riding with ${name} to ${title} </h1>

${cost}${costfor2}${costfor3}
<br>

			<input type="radio" value="roundtrip" name="tripoption">Round Trip
			<input type="radio" value="roundtrip" name="tripoption">One Way
			<!-- It hates line 26!!! -->
			<!--  <a href="/joinride/${ride.ride_id}/${sessionUser.user_id}">Link</a> -->

<a href="/"><button>search again</button></a>
</div>


</body>
</html>