<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Gestion des Villes</title>
<!-- Add Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/ville.css">

</head>

<body>
	<jsp:include page="navbar.jsp" />
	<div class="container flex-box ville">
		<div class="form-container">
			<h1 class="display-4 text-center mb-4">Gestion des Villes</h1>
			<form action="VilleController" method="post" class="mb-3">

				<div class="form-row flex-box">
					<div class="col">
						<label class="form-label" for="ville">Nom :</label>
					</div>
					<div class="col">
						<input type="text" class="form-control" name="ville" value="" />
					</div>
					<div class="btn-group col">
						<button class="btn btn-success" name="action" value="create">Enregistrer</button>
					</div>
				</div>

			</form>
			<hr>
			<!-- <form action="VilleController" method="post" class="mb-3"> -->
			<h2 class="mb-3">Liste des villes :</h2>
			<table>

				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${villes}" var="v">
						<tr>
							<td>${v.id}</td>
							<td>${v.nom}</td>
							<td>
								<form action="VilleController" method="get" class="inline-form">
									<input type="hidden" name="id" value="${v.id}"> <input
										type="hidden" name="action" value="edit">
									<button type="submit" class="btn btn-primary btn-sm">Modifier</button>
								</form>
							</td>
							<td>
								<form action="VilleController" method="post"
									onsubmit="return confirmDelete();" class="inline-form">
									<input type="hidden" name="id" value="${v.id}"> <input
										type="hidden" name="action" value="delete">
									<button type="submit" class="btn btn-danger btn-sm">Supprimer</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

	<script>
		function confirmDelete() {
			return confirm("Confirm to delete the City and Associated Hotels?");
		}
	</script>


</body>


</html>
