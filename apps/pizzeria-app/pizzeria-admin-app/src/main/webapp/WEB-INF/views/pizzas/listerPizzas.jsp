<%@page import="fr.pizzeria.modele.Pizza"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Bienvenue sur le site web de la pizzéria "La Florentina"</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
		    <div class="well well-sm">
		        <strong>Format</strong>
		        <div class="btn-group">
		            <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list">
		            </span>List</a> <a href="#" id="grid" class="btn btn-default btn-sm">
		            <span class="glyphicon glyphicon-th"></span>Grid</a>
		        </div>
		    </div>
		    <div id="products" class="row list-group">
		    	<%
				List<Pizza> pizzas = (List<Pizza>) request.getAttribute("pizzas");
				for(Pizza pizza : pizzas){
				%>
		        <div class="item col-xs-4 col-lg-4">
		            <div class="thumbnail">
		                <img class="group list-group-image" src="<%=pizza.getUrl()%>" />
		                <div class="caption">
		                    <h4 class="group inner list-group-item-heading"><%=pizza.getCode()%></h4>
		                    <p class="group inner list-group-item-text">
		                        <%=pizza.getNom()%>
		                    </p>
		                    <p class="lead"><%=pizza.getPrix()%> euros</p>
		                    <a class="btn btn-success" href="<%= request.getContextPath() %>/pizzas/edit?code=<%=pizza.getCode()%>">Modifier</a>
		                    <a class="btn btn-success" href="<%= request.getContextPath() %>/pizzas/remove?code=<%=pizza.getCode()%>">Supprimer</a>
		                </div>
		            </div>
		        </div>
		        <%
				}
				%>
		    </div>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="<%= request.getContextPath() %>/script.js"></script>
    </body>
</html>