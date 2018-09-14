<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>
	<form action="/allsearch">
		<table style="border-spacing: 20px; margin: 0 auto; width: 75%">
					<tr>
						<td>search by location</td>
						<td><input type="text" style="font-size: 150%; width: 350px"
							name="queryloc" placeholder="where would you like to go?"></td>
					</tr>
					<tr>
						<td>search by keyword</td>
						<td><input type="text" style="font-size: 150%; width: 350px"
							name="queryname" placeholder="what is your event keyword?"></td>
					</tr>
					<tr>
						<td>search by date</td>
						<td><input type="text" style="font-size: 150%; width: 350px"
							name="querydate" placeholder="when is your event?"></td>
					</tr>
				</table>
				<br>
				<input type="submit" value="Find an Event">
	</form>


</body>
</html>