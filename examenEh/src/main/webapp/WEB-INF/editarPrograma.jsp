<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title> Editar Programa </title>
	</head>
	<body>
		<div class="container">
			<div class="col-6">
				<h1> Editar ${programa.titulo} </h1>
			    <form action="/programas/${programa.id}/actualizar" method="POST" modelAttribute="programa">
			    
			    	<div class="mt-4">
				        <label class="form-label" for="titulo"> Título: </label>
				        <input class="form-control mb-4" type="text" id="titulo" name="titulo" value="${programa.titulo}">
				        <div class="d-grid">
				        	<form:errors path="tituloEditar" class="alert alert-danger"/>
				        </div>
			        </div>
			        
			        <div class="mt-4">
				        <label class="form-label" for="red"> Red: </label>
				        <input class="form-control mb-4" type="text" id="red" name="red" value="${programa.red}">
				        <div class="d-grid">
				        	<form:errors path="red" class="alert alert-danger"/>
				        </div>
			        </div>
			        
			        <div class="mt-4">
				        <label class="form-label" for="descripcion"> Descripción: </label>
				        <input class="form-control mb-4" type="text" id="descripcion" name="descripcion" value="${programa.descripcion}">
				        <div class="d-grid">
				        	<form:errors path="descripcion" class="alert alert-danger"/>
				        </div>
			        </div>
			        
			        <div class="d-flex justify-content-end">
		    			<a class="btn btn-primary me-2" href="/programas"> Cancelar </a>
			        	<button class="btn btn-primary" type="submit"> Enviar </button>
			        </div>
			        
			    </form>
			    
			    <form action="/programas/${programa.id}/eliminar" method="post">
			        <button  class="btn btn-danger" type="submit"> Eliminar </button>
			    </form>
			</div>
		</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>