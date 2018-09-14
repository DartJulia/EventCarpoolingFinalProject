<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Optional Car Info</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
	
<style>
	form {
	width: 30%;
	margin: 0 auto;
	}

</style>
</head>
<body>

<body>

	<h1 align="center">ADDITIONAL CAR INFO (OPTIONAL)</h1>
	
	<div class="container">
	
	<a href="/"><button>skip this step</button></a>

		<!-- <form action="/carsave"> -->
		<form>

			<div class="form-group">
				<label>Enter Your Car Type (SUV or sedan):</label> <input type="text"
					class="form-control" name="car_type" value="${user.car_type}" placeholder="Car Type">
				<!-- if name = POJO variable names, don't need to use RequestParam or PathVariable; pass in User object on controller side-->
				<label>Enter your car's total number of seats:</label> <input type="number"
					class="form-control" name="seats" value="${user.seats}" placeholder="Seats">

				<label>Enter Your License Plate Number</label> <input type="text"
					class="form-control" name="plate" value="${user.plate}" placeholder="Plate Number">
			</div>
			
			<a href="/carsave/${user.car_type}/${user.seats}/${user.plate}">add</a>
			
			<!-- <input type="submit" value="Submit"> -->
		</form>


	</div>


<%-- User: ${user} --%>


</body>
</html>