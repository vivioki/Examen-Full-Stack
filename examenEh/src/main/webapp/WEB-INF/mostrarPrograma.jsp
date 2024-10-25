<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title> Detalles </title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-6">
					<h1> ${programa.titulo} </h1>
				</div>
				<div class="col-6 mt-3">
					<a href="/programas"> Volver al Panel </a>
				</div>
		    
			</div>
		    <div class="row">
		    	<h5> Agregado por: ${usuario} </h5>
		    	<p class="mt-2"> Red de Televisión: ${programa.red} </p>
		    	<p> Descripción: ${programa.descripcion} </p>
		    </div>
		    <div class="row">
		    	<form action="/programas/${programa.id}/editar" method="GET">
	        		<button class="btn btn-primary" type="submit"> Editar </button>
	    		</form>
		    </div>
		   
	    </div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>