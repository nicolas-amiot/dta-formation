<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Bienvenue sur le site web de la pizzéria "La Florentina"</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:url value='/style.css'/>">
    </head>
    <body>
        <div class="container">
		    <div class="well well-sm">
		        <strong>Format</strong>
		        <div class="btn-group">
		            <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list"></span>List</a>
		            <a href="#" id="grid" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th"></span>Grid</a>
		        </div>
		        <a href="<c:url value='/pizzas/new'/>" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-plus"></span>Ajouter une pizza</a>
		      	<a href="<c:url value='/logout'/>" class="btn btn-primary btn-sm btn-right"><span class="glyphicon glyphicon-off"></span>Deconnexion</a>
		    </div>
		    <div id="products" class="row list-group">
				<c:forEach var="pizza" items="${pizzas}">
			        <div class="item col-xs-12 col-sm-4">
			            <div class="thumbnail">
			                <img class="group list-group-image" src="${pizza.url}" />
			                <div class="caption">
			                    <h4 class="group inner list-group-item-heading">${pizza.nom} (${pizza.code})</h4>
			                    <p class="group inner list-group-item-text">${pizza.categorie.libelle}</p>
			                    <p class="lead"><fmt:formatNumber type="currency" currencySymbol="EUR" minFractionDigits="2" value="${pizza.prix}" /></p>
			                    <a class="btn btn-warning" href="<c:url value='/pizzas/edit?code=${pizza.code}'/>"><span class="glyphicon glyphicon-pencil"></span>Modifier</a>
			                    <a class="btn btn-danger" href="<c:url value='/pizzas/remove?code=${pizza.code}'/>"><span class="glyphicon glyphicon-remove"></span>Supprimer</a>
			                </div>
			            </div>
			        </div>
		        </c:forEach>
		    </div>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="<c:url value='/script.js'/>"></script>
    </body>
</html>