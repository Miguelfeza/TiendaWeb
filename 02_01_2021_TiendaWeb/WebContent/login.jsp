<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario login</title>
<link rel="Stylesheet" href="estilos/estilos.css" />
</head>
<body>
<h1>AMATRON S.A</h1>
<p class="plantilla2"  >Tu tienda online de consumibles informaticos</p>
<img  class="redondo" src="imagenes/fondo.jpg" alt="Batman"/>
<h1>Tienda online</h1>
	<div>
		<h1>Login</h1>
		<form action="sverifica" method="post" />
		Usuario : <input type="email" name="usuario" /> </br> Contraseña : <input
			type="password" name="password" /> </br> 
	    <input type="submit"
			value="Confirmar Credenciales" />
		</form>
	</div>
</body>
</html>