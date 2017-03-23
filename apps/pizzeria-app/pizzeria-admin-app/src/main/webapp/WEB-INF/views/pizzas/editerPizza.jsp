<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	        <div class="span3 well">
	        	<legend>Modification d'une pizza</legend>
	            <form method="POST" action="<c:url value='/pizzas/edit?old_code=${pizza.code}'/>">
	                <input class="form-control" type="text" name="code" id="code" placeholder="Code" value="${pizza.code}" /><br><br>
	                <input class="form-control" type="text" name="nom" id="nom" placeholder="Nom" value="${pizza.nom}" /><br><br>
	                <input class="form-control" type="number" name="prix" id="prix" placeholder="Prix" step="0.01" value="${pizza.prix}" /><br><br>
	                <input class="form-control" type="text" name="categorie" id="categorie" placeholder="Catégorie" value="${pizza.categorie}" /><br><br>
	                <input class="form-control" type="text" name="image" id="image" placeholder="Url de l'image" value="${pizza.url}" /><br><br>
	                <div class="container-btn">
	                	<input class="btn btn-success" type="submit" value="Modifier" />
	                </div>
	            </form>
	        </div>
        </div>
    </body>
</html>