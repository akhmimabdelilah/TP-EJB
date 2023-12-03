<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Recherche des Hotels</title>


<link rel="stylesheet" href="styles/hotel.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous"> -->


</head>

<body>
	<jsp:include page="navbar.jsp" />
	<div class="container flex-box hotel">
		<div class="form-container">
			<h1 class="display-4 text-center mb-4">Recherche des Hotels</h1>

			<form action="HotelController" method="get" class="mb-3">
				<div class="form-row flex-box">
					<div class="col">
						<label for="villeInput" for="nom">Ville :</label>
					</div>
					<div class="col">
						<input type="text" class="form-control" name="ville" required />
					</div>
					<div class="btn-group col">
						<button class="btn btn-success" name="action" value="search">Rechercher</button>
					</div>

					<%-- <div class="col">
						<label class="form-label" for="ville">Ville :</label> <select
							name="ville" class="form-control col" id="modalhotelVille">

							<c:forEach items="${villes}" var="v">
								<option>${v.nom}</option>
							</c:forEach>
						</select>
					</div> --%>
				</div>


			</form>
			<hr>
			<form action="HotelController" method="get" class="mb-4">

				<div class="col form-group">
					<label class="form-label" for="filterVille">Filtre par
						Ville :</label> <select name="ville" class="form-control col"
						id="modalhotelVille">
						<option value="0">All</option>
						<c:forEach items="${villes}" var="v">
							<option value="${v != null ? v.id : 0}">${v != null ? v.nom : 'All'}</option>
						</c:forEach>
					</select>
				</div>
				<input type="hidden" name="action" value="search">
				<button type="submit" class="btn btn-primary">Filter</button>
				<hr>
				<table>
					<thead>
						<tr>
							<th>ID</th>
							<th>Nom</th>
							<th>Adresse</th>
							<th>Telephone</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${hotels}" var="h">
							<tr>
								<td>${h.id}</td>
								<td>${h.nom}</td>
								<td>${h.adresse}</td>
								<td>${h.telephone}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</form>

		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>


	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

	<!-- <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script> -->


	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<!-- <script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script> -->



</body>
</html>
