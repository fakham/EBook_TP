<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook</title>
<!-- <link href="../css/bootstrap.css" rel="stylesheet" type="text/stylesheet">
<script type="text/javascript" src="../js/bootstrap.js"></script> -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4">
		<div class="card">
			<div class="card-header">
				Liste des livres
			</div>
			<div class="card-body">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Description</th>
							<th scope="col">Prix</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="livre" items="${livres}">
							<tr>
								<td>${ livre.description }</td>
								<td>${ livre.prix } DH</td>
								<td>
									<form method="post" action="Cart">
										<input type="hidden" value="${ livre.id }" name="id">
										<input type="submit" value="Add To Cart" class="btn btn-success">
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>