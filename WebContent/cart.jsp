<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4">
		<div class="card">
			<div class="card-header">Votre chariot</div>
			<div class="card-body">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Quantité</th>
							<th scope="col">Description</th>
							<th scope="col">Prix</th>
							<th scope="col">Montant</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="livre" items="${ cart_livre.livres }">
							<tr>
								<td>
									<form method="post" action="/EBook_TP/Cart">
										<div class="input-group mb-3">
											<input type="hidden" name="id" value="${ livre.id }"> 
											<input class="custom-number" name="qtte" type="number" value="${ livre.qtte }">
											<div class="input-group-append">
												<input class="btn btn-outline-secondary" type="submit" value="Update">
											</div>
										</div>
									</form>
								</td>
								<td>${ livre.description }</td>
								<td>${ livre.prix } DH</td>
								<td>${ Math.round(livre.prix * livre.qtte) } DH</td>
								<td>
									<form method="post" action="/EBook_TP/Cart">
										<input type="hidden" name="remove" value="${ livre.id }">
										<input type="submit" class="btn btn-danger" value="Remove Item">
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<blockquote class="blockquote mb-0">
					<footer class="blockquote-footer">
						<span class="txt-bold h6">Pour changer la quantité.</span> Entrez
						la nouvelle quantité puis appuyez sur le bouton Update.
					</footer>
				</blockquote>
				<div class="row mt-5">
					<div class="col col-md-2">
						<a href="/EBook_TP/" class="btn btn-success">Continuer vos
							achats</a>
					</div>
					<div class="col col-md-2">
						<form action="Checkout" method="post">
							<input type="submit" value="Checkout" class="btn btn-warning">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>