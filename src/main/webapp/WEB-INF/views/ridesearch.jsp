<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>
<br>
<h5>Rides matching your search:</h5>

<form> <!--  CAN BE A REQUESTPARAM -->
			<table style="border-spacing: 20px; margin: 0 auto; width: 100%">
					<tr>
						<th></th>
						<th>ride id</th>
						<th>event title</th>
						<th>driver id</th>
						<th></th>
					</tr>
<c:forEach var="event" items="${titletag}">

<tr>
						<td>${event.rideid}</td>
						<td>${event.eventid}
						<td>${event.eventtitle}</td>
						<td>${event.userid }</td>
						<%-- <td><a href="/pullevent/${event.id}/${event.title}">Yes</a></td> --%>
					</tr>

</c:forEach>
</form>

<br>
<a href="/">Go Back</a>
</body>
</html>