<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="com.nowe.negocio.Carrito"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.nowe.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito</title>
</head>
<link rel="Stylesheet" href="estilos/estilos.css" />

<body>
<header>
<img  class="redondo" src="imagenes/fondo.jpg" alt="Batman"/>
<h1>Tienda online</h1>
<div class="topnav">
  <a href="stodosproductos">Mostrar todos los productos</a>
  <a href="mostrarcarrito.jsp">Mostrar carrito</a>
  <a href="#">Link</a>
</div>
</header>
	<h1>Carrito</h1>
	<% Carrito c1 = (Carrito) session.getAttribute("carrito");
	if(c1==null){
		
	
	 %>
	 <p>Carrito vacio</p>
	 <% }else{ %>
	 <p>El importe de su carrito es:  <%= c1.getImporte() %>
	<table>
		<tr>
			<th>Numero producto</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad en tienda</th>
			<th>Eliminar del carrito</th>
		</tr>
		<% for(Producto p :c1.getContenido()) {%>
		<tr>
			<td><%=p.getIdproducto() %></td>
			<td><%=p.getNombre() %></td>
			<td><%=p.getPrecio() %></td>
			<td><%=p.getCantidadExistencia() %></td>
			<td>
				  <a href="sremovecarrito?id=<%=p.getIdproducto()%>">Eliminar del carrito
				</a> 
			</td>
		</tr>

		<% } %>
		
	</table>
	<% } %>
	
	<button onclick="location.href='stodosproductos'">Continuar comprando</button>
</body>
</html>