<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="<c:url value='/style.css'/>">
	</head>
	<body>
		<div class="container">
			<h3>Ingredients</h3>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Prix</th>
						<th>Quantité</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ingredient" items="${ingredients}">
						<tr>
							<td>${ingredient.nom}</td>
							<td>${ingredient.prix}</td>
							<td>${ingredient.quantite}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>