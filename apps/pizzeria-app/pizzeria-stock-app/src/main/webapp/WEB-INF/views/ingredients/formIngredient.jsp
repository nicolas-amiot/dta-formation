<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Insert title here</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:url value='/style.css'/>">
    </head>
    <body>
    <div class="container">
	        <div class="span3 well">
	        	<legend>Modifier d'un ingredient</legend>
	            <form method="POST" action="<c:url value='/mvc/ingredients'/>">
	            	<input type="hidden" name="id" value="${ingredient.id}">
	                <input class="form-control" type="text" name="nom" id="nom" placeholder="Nom" value="${ingredient.nom}" /><br><br>
	                <input class="form-control" type="number" name="prix" id="prix" placeholder="Prix" step="0.01" value="${ingredient.prix}" /><br><br>
	                <input class="form-control" type="number" name="quantite" id="quantite" placeholder="Quantité" step="1" value="${ingredient.quantite}" /><br><br>
	                <div class="container-btn">
	                	<input class="btn btn-success btn-right" type="submit" value="Modifier" />
	                </div>
	            </form>
	        </div>
        </div>
    </body>
</html>