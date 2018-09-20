<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <link rel="stylesheet"
	href="https://bootswatch.com/4/lux/bootstrap.min.css" /> 
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="images/favicon.png">
        <title>Ride Search</title>
        Bootstrap core CSS
        <link href="css/bootstrap.min.css" rel="stylesheet">
        Custom styles for this template
        <link href="css/style.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/custom.js" type="text/javascript"></script>
        <link rel="stylesheet" href="jobotest.css" type="text/css">  -->
        
        <style>
        a { color: #000000; } 
		a:hover { color: #00FF00; } /* CSS link hover (green) */
        .top-nav-bar {
    right: 60px;
    position: absolute;
    top: 60px;
    z-index: 99999;

}
        
        </style>

</head>
<body style="background-color:	#D3D3D3">

<div class="top-nav-bar" style="font-size:1.5em; top-margin:10px">
${sessionUser.first_name }
		<a href="/" style="padding: 10px">Home</a> 
			<a href="/logout" style="padding: 20px">Logout</a>
</div>


<div style="margin-left: 50px; margin-right: 50px; text-align: center">

	
	
	<div style="margin-top: 160px">
		<h1 style="text-align: center">SEARCH AVAILABLE RIDES BY CITY</h1>
	</div>
	
	<p style="color:red; font-size:15px">${noseats}</p>
	<form style="align: center" action="/rideresults"> 
	<div style="margin-top: 100px">
		<input type="text" style="font-size: 150%; border-radius:10px;width: 350px; padding: 10px"
									name="query"  placeholder="What city are you searching in?">
	</div>

	<div style="margin-top: 40px">
		<button class="btn-primary" style="border-radius:10px; font-size:16px; padding:8px">Find Rides</button>
	</div>
	</form>
	

		<br>

</div>
</body>
</html>