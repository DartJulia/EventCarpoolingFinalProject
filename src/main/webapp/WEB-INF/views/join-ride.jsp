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

<h1> ${user} is riding with ${ride} to ${event} </h1>

<a href="/"><button>search again</button></a>
</div>


</body>
</html>