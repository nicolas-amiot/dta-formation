<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<section id="login">
		    <div class="container">
		    	<div class="row">
		    	    <div class="col-xs-12">
		        	    <div class="form-wrap">
		                <h1>Log in with your email account</h1>
		                    <form method="POST" action="<c:url value='/login'/>">
		                        <div class="form-group">
		                            <label for="email" class="sr-only">Email</label>
		                            <input type="email" name="email" id="email" class="form-control" placeholder="Email">
		                        </div>
		                        <div class="form-group">
		                            <label for="key" class="sr-only">Password</label>
		                            <input type="password" name="password" id="password" class="form-control" placeholder="Password">
		                        </div>
		                        <div class="checkbox">
		                            <span class="character-checkbox" onclick="showPassword()"></span>
		                            <span class="label">Show password</span>
		                        </div>
		                        <input type="submit" class="btn btn-custom btn-lg btn-block" value="Log in">
		                    </form>
		        	    </div>
		    		</div>
		    	</div>
		    </div>
		</section>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="<c:url value='/script.js'/>"></script>
	</body>
</html>