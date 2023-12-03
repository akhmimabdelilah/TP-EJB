<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Ville</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/ville.css">
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="container ville flex-box">
		<h1 class="display-4 text-center mb-4">Modifier ville</h1>

		<!-- Form to add a new city -->
		<form class="custom_class mb-3" action="VilleController" method="post">
			<div class="form-row flex-box">
				<div class="col">
					<label for="villeInput">Nom :</label>
				</div>
				<div class="col mr-2">
					<input type="text" name="ville" class="form-control"
						id="villeInput" placeholder="Enter city name"
						value="${updateVille != null ? updateVille.nom : ''}" required>
				</div>
				<div class="col mr-2">
					<input type="hidden" name="action"
						value="${updateVille != null ? 'update' : 'create'}"> <input
						type="hidden" name="id"
						value="${updateVille != null ? updateVille.id : ''}">
					<button type="submit" class="btn btn-primary">${updateVille != null ? 'Update' : 'Enregistrer'}</button>
				</div>

			</div>
		</form>

	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


</body>
</html>