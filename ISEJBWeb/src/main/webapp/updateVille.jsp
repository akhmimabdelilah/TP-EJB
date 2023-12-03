<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Ville</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="container">
		<h1 class="text-center mb-4">Modifier ville</h1>

		<!-- Form to add a new city -->
		<form class="custom_class" action="VilleController" method="post"
			class="form-inline mb-3">
			<div class="form-group mr-2">
				<label for="villeInput" class="sr-only">Nom :</label> <input
					type="text" name="ville" class="form-control" id="villeInput"
					placeholder="Enter city name"
					value="${updateVille != null ? updateVille.nom : ''}" required>
			</div>
			<input type="hidden" name="action"
				value="${updateVille != null ? 'update' : 'create'}"> <input
				type="hidden" name="id"
				value="${updateVille != null ? updateVille.id : ''}">
			<button type="submit" class="btn btn-primary">${updateVille != null ? 'Update' : 'Enregistrer'}</button>
		</form>

	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


</body>
</html>