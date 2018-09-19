<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
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
        <link rel="stylesheet" href="jobotest.css" type="text/css"> 
        
         <style>
        a { color: #000000; }
		a:hover { color: #00FF00; } /* CSS link hover (green) */
        </style>
        
    </head>
<!-- <head>
<meta charset="ISO-8859-1">
<title>Home</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" /> 
<link rel="stylesheet" href="jobotest.css" type="text/css"> 
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/scrolling-nav.css" type="text/css">


</head> -->
<body style="background-color:#02000f">
<!-- class="container" style="text-align: right"-->

<div class="top-nav-bar" style="font-size:1.5em">

		
	
			<a href="/registerpage" style="padding: 20px">sign up</a> 
			<a href="/login" style="padding: 20px">login</a>
			<a href="/logout" style="padding: 20px">logout</a>
			<br>
	<p style="text-align: center">${welcome} ${sessionUser.first_name}!</p>
</div>

	
	<div class="banner-full-image">

		<div align="center">
		
<img src="images/logo.png" style="height:50%; width:50%">
			<!-- <h1 style="text-align: center; font-size: 100px">RIDING SHOTGUN!</h1> -->
			
          
			    		<br>
						<br>
						<br>
						<br>
						<br>
						<br>
			<p style="text-align: center; font-size: 250%; color:white">Find rides to
				events nationwide</p>
			

			<br>

		</div>
</div>
<br>
<br>

<div align="center">

			<form name="searchform" action="/ridesearch">
	
			<label class="switch">
				<input class="switch-input" type="checkbox" id="rideordrive" value="yes" checked="false">
				<span class="switch-label" data-on="Rider" data-off="Driver"></span> 
				<span class="switch-handle"></span> 
			</label>
			<button class="btn-primary">Find</button>
	
				
			</form>
	</div>
<script src="index.js"></script>

</body>
</html>