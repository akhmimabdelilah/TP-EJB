<%-- 
    Author     : akhmim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Navbar Page</title>
<link href="styles/nav.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="nav navbar-expand-lg navbar-light bg-light flex-box">
		<div class="logo">
			<a class="navbar-brand logo" href="index.jsp"> <img
				src="images/city.png" alt="Logo" width="70" height="50">
			</a>
		</div>
		<div class="navbar-collapse menu" id="navbarNav">
			<a class="nav-link" href="index.jsp"> Home </a> <a class="nav-link"
				href="ville.jsp">Ville</a> <a class="nav-link" href="hotel.jsp">Hotel</a>
			<a class="nav-link" href="search.jsp">Search</a>
		</div>
		<div class="logo">
			<a class="navbar-brand logo" href="index.jsp"> <img
				src="images/hotel.png" alt="Logo" width="70" height="50">
			</a>
		</div>

	</div>


</body>
</html>
