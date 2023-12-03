<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Hotel</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="container">
		<h1 class="text-center mb-4">Modifier ville</h1>

		<!-- Form to add a new city -->
		<form class="custom_class" action="HotelController" method="post"
			class="form-inline mb-3">
			<div class="form-group mr-2">
				<div class="col">
					<label class="form-label" for="nom" class="sr-only">Nom :</label> <input
						type="text" class="form-control" name="hotel"
						placeholder="Enter city name"
						value="${updateHotel != null ? updateHotel.nom : ''}" required />
				</div>
				<div class="col">
					<label class="form-label" for="adresse">Adresse :</label> <input
						type="text" class="form-control" name="adresse"
						value="${updateHotel != null ? updateHotel.adresse : ''}" required />
				</div>
				<div class="col">
					<label class="form-label" for="telephone">Telephone :</label> <input
						type="text" class="form-control" name="telephone"
						value="${updateHotel != null ? updateHotel.telephone : ''}"
						required />

				</div>
				<%-- <div class="col">
					<label class="form-label" for="ville">Ville :</label> <select
						name="ville" class="form-control col" id="modalhotelVille">
						<c:forEach items="${villes}" var="v">
							<option>${updateHotel != null ? v.nom : ''}</option>
						</c:forEach>
					</select>
				</div> --%>
			</div>
			<input type="hidden" name="action"
				value="${updateHotel != null ? 'update' : 'create'}"> <input
				type="hidden" name="id"
				value="${updateHotel != null ? updateHotel.id : ''}">
			<button type="submit" class="btn btn-primary">${updateHotel != null ? 'Update' : 'Enregistrer'}</button>
		</form>

	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>