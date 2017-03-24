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
			<h3>Temps d'exécutions des requêtes</h3>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Pages exécutées</th>
						<th>Temps d'exécutions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="temps" items="${tempsRequetes}">
						<tr>
							<td>${temps.key}</td>
							<td>${temps.value} ms</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td>Nombre de sessions ouvertes en cours</td>
						<td> ${compteur}</td>
					</tr>
				</tfoot>
			</table>
			<h3>Opérations sur les pizzas</h3>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Type d'opération</th>
						<th>Pizza concernée</th>
						<th>Date de l'opération</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="event" items="${events}">
						<tr>
							<td>${event.methode}</td>
							<td>${event.pizza}</td>
							<td>${event.dateCreation}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>