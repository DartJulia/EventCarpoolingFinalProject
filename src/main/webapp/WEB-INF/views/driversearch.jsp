<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

 
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
<body style="background-color:	#D3D3D3"">

<div class="top-nav-bar" style="font-size:1.5em">

		${sessionUser.first_name }
		<a href="/" style="padding: 10px">Home</a> 
			<a href="/logout" style="padding: 20px">Logout</a>
</div>
<div style="margin-left: 50px; margin-right: 50px; text-align: center">

	<div style="margin-top: 160px">
		<h1 style="text-align: center">SEARCH EVENTS TO DRIVE TO</h1>
	</div>
<br>



<br>
<br>

	<form action="/allsearch">
		
						<label style="font-size:130%; padding:30px">Search by location</label>
						<input type="text" style="font-size: 150%; width: 350px; height:40px; border-radius:6px"
							name="queryloc" placeholder="Where would you like to go?" required>
							<br>
					<label style="font-size:130%; padding:30px">Search by keyword</label>
						<input type="text" style="font-size: 150%; width: 350px; height:40px; border-radius:6px"
							name="queryname" placeholder="What is your event keyword?">
							<br>
					<label style="font-size:130%; padding:30px">Search by date</label>
						<input type="text" style="font-size: 150%; width: 350px; height:40px; border-radius:6px"
							name="querydate" placeholder="When is your event?">
					<br>
				<br>
				<button class="btn-primary">Find an Event</button>
			
	</form>


</body>
</html>