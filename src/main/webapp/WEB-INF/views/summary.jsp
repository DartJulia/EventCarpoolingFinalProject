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
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/custom.js" type="text/javascript"></script>
        <link rel="stylesheet" href="jobotest.css" type="text/css"> 
    </head>
<body style="background-color:	#D3D3D3">


<div class="top-nav-bar" style="text-align: right">

${sessionUser.first_name}
<a href="/" style="padding: 20px">Home</a>
<a href="/logout" style="padding: 20px">logout</a>

</div>
<h1>You are Confirmed!</h1>
Gas Donation Options: <br><br>
Cost for one rider: $${cost} <br>
Cost for two riders: $${costfor2} <br>
Cost for three riders: $${costfor3}

<h3>Enjoy your ride!</h3>

</body>
</html>