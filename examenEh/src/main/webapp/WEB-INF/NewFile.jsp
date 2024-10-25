<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<title> EcoFinance </title>
	</head>
	<body>
		<!-- Nav -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light text-center">
        <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#home"> Home </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#about"> Sobre Nosotros </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#services"> Servicios </a>
                </li>
            </ul>
        </div>
    </nav>
	<!-- Home -->
    <header id="home" class="container mt-5">
        <h1 class="text-center"> Bienvenido a EcoFinance </h1>
        <div class="row align-items-center mt-4">
            <div class="col-md-6">
                <p> EcoFinance, es una página web diseñada para ayudar a las personas a gestionar sus finanzas personales de manera 
                eficiente. Los usuarios pueden registrarse, agregar sus ingresos y gastos, y categorizar sus tipos de gastos. 
                Esto les permitirá tener un control claro y organizado de sus finanzas, ayudándolos a tomar decisiones económicas informadas.</p>
                <button class="btn btn-primary" onclick="location.href='<c:url value='/login' />'"> Entrar </button>
            </div>
            <div class="col-md-6 text-center">
                <img src="<c:url value='/images/img.jpg' />" class="img-fluid" alt="Welcome Image">
            </div>
        </div>
    </header>
	<!-- About  -->
    <section id="about" class="container mt-5">
        <h2 class="text-center"> Sobre Nosotros </h2>
        <div class="row align-items-center mt-4">
            <div class="col-md-6 text-center">
                <img src="<c:url value='/images/img.jpg' />" class="img-fluid" alt="About Us Image">
            </div>
            <div class="col-md-6">
                <p> Nuestro propósito es ayudar a las personas a gestionar sus finanzas personales de manera eficiente. </p>
            </div>
        </div>
    </section>
	<!-- Services -->
    <section id="services" class="container mt-5">
        <h2 class="text-center"> Servicios </h2>
        <div class="row align-items-center mt-4">
            <div class="col-md-6">
                <img src="<c:url value='/images/img.jpg' />" class="img-fluid" alt="Service Image 1">
            </div>
            <div class="col-md-6">
                <p> Curso Educación Financiera. </p>
            </div>
        </div>
        <div class="row align-items-center mt-4">
            <div class="col-md-6">
                <img src="<c:url value='/images/img.jpg' />" class="img-fluid" alt="Service Image 2">
            </div>
            <div class="col-md-6">
                <p> Consultoría personal. </p>
            </div>
        </div>
        <div class="row align-items-center mt-4">
            <div class="col-md-6">
                <img src="<c:url value='/images/img.jpg' />" class="img-fluid" alt="Service Image 3">
            </div>
            <div class="col-md-6">
                <p> Foros y Comunidades. </p>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="bg-light text-center py-3 mt-5">
        <p> &copy; 2024 EcoFinance. Todos los derechos reservados. </p>
    </footer>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>