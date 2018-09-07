<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events list</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<input type="text" name="query" placeholder="where would you like to go?"><br>

<form action="/">
		<label for="event">${event.title}</label>
		<select name = "event">
			<c:forEach var="event" items="${events}">
				<option value="${event.title}">${event.title}</option>
			</c:forEach>
		</select>
	<input type="submit" value="select">
</form>		

</body>
</html>