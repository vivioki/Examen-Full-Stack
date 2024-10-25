<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title> TVDB </title>
	</head>
	<body>
	<div class="container">
		<h1 class=" text-primary mt-4 text-center "> Bienvenidos a TVDB! </h1>
		<div  class="row">
			<div class="col-6">
				<h2> Registrarte </h2>
				<form:form action="/registrar" method="POST" modelAttribute="nuevoUsuario">
				
					<div class="mt-4">
						<label class="form-label" for="nombre"> Nombre: </label>
				        <input class="form-control mb-4" type="text" id="nombre" name="nombre">
				        <div class="d-grid">
				        	<form:errors path="nombre" class="alert alert-danger" />
				        </div>
			        </div>
			        
			        <div class="mt-4">
				        <label class="form-label" for="correo"> Correo: </label>
				        <input class="form-control mb-4" type="email" id="correo" name="correo">
				        <div class="d-grid">
				        	<form:errors path="correo" class="alert alert-danger" />
				        </div>
			        </div>
			        
			        <div class="mt-4">
				        <label class="form-label" for="password"> Contraseña: </label>
				        <input class="form-control mb-4" type="password" id="password" name="password">
				        <div class="d-grid">
				        	<form:errors path="password" class="alert alert-danger" />
				        </div>
			        </div>
			        
			        <div class="mt-4">
				        <label class="form-label" for="confirmacionPassword"> Confirmación: </label>
				        <input class="form-control mb-4" type="password" id="confirmacionPassword" name="confirmacionPassword">
				        <div class="d-grid">
				        	<form:errors path="password" class="alert alert-danger" />
				        </div>
			        </div>
			        
			        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
			        	<button class="btn btn-primary mt-2" type="submit"> Registrate </button>
			        </div>
			        
				</form:form>
			</div>
			<!--  -->
			<div class="col-6">
				<h2> Iniciar Sesión </h2>
				<form:form action="/login" method="POST" modelAttribute="usuarioLogin">
				
					<div class="mt-4">
						<label class="form-label" for="usuarioCorreo"> Correo: </label>
				        <input class="form-control mb-4" type="email" id="usuarioCorreo" name="usuarioCorreo">
				        <div >
				        	<form:errors path="usuarioCorreo" class="alert alert-danger" />
				        </div>
			        </div>
			        
			        <div class="mt-4">
				        <label class="form-label" for="usuarioPassword"> Contraseña: </label>
				        <input class="form-control mb-4" type="password" id="usuarioPassword" name="usuarioPassword">
				        <div>
				        	<form:errors path="usuarioPassword" class="alert alert-danger" />
				        </div>
			       	</div>
			       	
			       	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			       		<button class="btn btn-primary mt-2" type="submit"> Iniciar Sesión </button>
			       	</div>
			        
				</form:form>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>