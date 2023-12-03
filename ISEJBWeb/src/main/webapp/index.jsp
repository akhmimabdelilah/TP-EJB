<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>City & Hotel Management</title>
<!-- Add Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/main.css">

</head>
<body>
	<div class="container home flex-box">
		<div class="jumbotron">
			<h1 class="display-4 text-center mb-4">HomePage</h1>
		</div>

		<div class="row">
			<!-- Left column for city management -->
			<div class="col-md-6">
				<a href="ville.jsp" class="btn btn-primary btn-block"><span
					class="display-4 text-center m-4">City Management</span></a>
			</div>

			<!-- Right column for hotel management -->
			<div class="col-md-6">
				<a href="hotel.jsp" class="btn btn-primary btn-block"><span
					class="display-4 text-center m-4">Hotel Management</span></a>
			</div>
		</div>
	</div>
</body>
</html>
