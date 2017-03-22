<%@page import="fr.pizzeria.modele.Pizza"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%
Pizza pizza = (Pizza) request.getAttribute("pizza");
%>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Bienvenue sur le site web de la pizzéria "La Florentina"</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/style.css">
    </head>
    <body>
        <div class="container">
	        <div class="span3 well">
	        	<legend>Modification d'une pizza</legend>
	            <form method="POST" action="<%= request.getContextPath() %>/pizzas/edit?old_code=<%=pizza.getCode()%>">
	                <input class="form-control" type="text" name="code" id="code" placeholder="Code" value="<%=pizza.getCode()%>" /><br><br>
	                <input class="form-control" type="text" name="nom" id="nom" placeholder="Nom" value="<%=pizza.getNom()%>" /><br><br>
	                <input class="form-control" type="number" name="prix" id="prix" placeholder="Prix" step="0.01" value="<%=pizza.getPrix()%>" /><br><br>
	                <input class="form-control" type="text" name="categorie" id="categorie" placeholder="Catégorie" value="<%=pizza.getCategorie()%>" /><br><br>
	                <input class="form-control" type="text" name="image" id="image" placeholder="Url de l'image" value="<%=pizza.getUrl()%>" /><br><br>
	                <div class="container-btn">
	                	<input class="btn btn-success" type="submit" value="Modifier" />
	                </div>
	            </form>
	        </div>
        </div>
    </body>
</html>