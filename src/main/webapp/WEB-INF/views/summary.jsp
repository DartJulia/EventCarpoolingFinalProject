<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="images/favicon.png">
        <title>I Call Shotgun</title>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet"
	href="https://bootswatch.com/4/lux/bootstrap.min.css" /> 
<link href="css/style.css" rel="stylesheet">
    </head>
<body style="background-color:	#D3D3D3">


<div class="top-nav-bar" style="text-align: right">

	${sessionUser.first_name}
	<a href="/" style="padding: 20px">Home</a>
	<a href="/logout" style="padding: 20px">logout</a>

</div>

<div style="text-align: center">
	
	<h1>You are Confirmed!</h1>
	Gas Donation Options: <br><br>
	Cost for one rider: $${cost} <br>
	Cost for two riders: $${costfor2} <br>
	Cost for three riders: $${costfor3}

	<h3>Enjoy your ride!</h3>

</div>

</body>
</html>