<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title> TVDB </title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-6">
					<h1> Bienvenidos, ${usuario}! </h1>
				</div>
				
				<div class="col-6 mt-3">
					<a href="/logout"> Cerrar Sesión </a>
				</div>
				
			</div>
			<div class="row">
	    		<h2> Programas </h2>
	    	</div>
	    	<div class="row">
			    <table class="table table-striped-columns table-bordered mt-3">
			        <thead>
			            <tr>
			                <th> Título </th>
			                <th> Red </th>
			            </tr>
			        </thead>
			        <tbody>
			            <c:forEach var="programa" items="${programas}">
			                <tr>
			                    <td><a href="/programas/${programa.id}"> ${programa.titulo} </a></td>
			                    <td> ${programa.red} </td>
			                </tr>
			            </c:forEach>
			        </tbody>
			    </table>
		    </div>
		    <div class="row">
			    <form action="/programas/nuevo" method="GET">
		        	<button class="btn btn-primary mt-2" type="submit"> Agregar Programa </button>
		    	</form>
	    	</div>
		</div>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>