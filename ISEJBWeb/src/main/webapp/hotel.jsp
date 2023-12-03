<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Gestion des Hotels</title>
<!-- Add Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/hotel.css">

</head>

<body>
	<jsp:include page="navbar.jsp" />
	<div class="container flex-box hotel">
		<div class="form-container">
			<h1 class="display-4 text-center mb-4">Gestion des Hotels</h1>

			<form action="HotelController" method="post" class="mb-3">
				<div class="form-row flex-box">
					<div class="col">
						<label class="form-label" for="nom">Nom :</label> <input
							type="text" class="form-control" name="nom" />
					</div>
					<div class="col">
						<label class="form-label" for="adresse">Adresse :</label> <input
							type="text" class="form-control" name="adresse" />
					</div>
					<div class="col">
						<label class="form-label" for="telephone">Telephone :</label> <input
							type="text" class="form-control" name="telephone" />

					</div>
					<div class="col">
						<label class="form-label" for="ville">Ville :</label> <select
							name="ville" class="form-control col" id="modalhotelVille">

							<c:forEach items="${villes}" var="v">
								<option>${v.nom}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="btn-group col">
					<button class="btn btn-success" name="action" value="create">Enregistrer</button>
				</div>

			</form>
			<hr>
			<h2 class="mb-3">Liste des hotels :</h2>

			<table>

				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Adresse</th>
						<th>Telephone</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${hotels}" var="h">
						<tr>
							<td>${h.id}</td>
							<td>${h.nom}</td>
							<td>${h.adresse}</td>
							<td>${h.telephone}</td>
							<td>
								<form action="HotelController" method="get" class="inline-form">
									<input type="hidden" name="id" value="${h.id}"> <input
										type="hidden" name="action" value="edit">
									<button type="submit" class="btn btn-primary btn-sm">Modifier</button>
								</form>
							</td>
							<td>
								<form action="HotelController" method="post"
									onsubmit="return confirmDelete();" class="inline-form">
									<input type="hidden" name="id" value="${h.id}"> <input
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
			return confirm("Confirm to delete the Hotel?");
		}
	</script>
</body>
</html>
