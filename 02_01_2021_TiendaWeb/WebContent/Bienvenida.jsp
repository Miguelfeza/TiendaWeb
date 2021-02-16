<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.nowe.modelo.Usuario"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenida</title>
</head>
<body>
<h1>Bienvenida</h1>
<%
Usuario jspUsuario= (Usuario) request.getAttribute("objetoUsuarioJava");
%>
Bienvenido <%=jspUsuario.getNombre() %>
</body>
</html>