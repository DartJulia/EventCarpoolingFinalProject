<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

</head>
<body>
<br>
<br>
<div class="top-nav-bar" style="font-size:1.5em">
	
			<a href="/" style="padding: 10px">Home</a> 
			<a href="/logout" style="padding: 10px">Logout</a>
			</div>

			
<h1>Search for Events to Drive To</h1>

<br>
<br>
<br>
<br>
<br>

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