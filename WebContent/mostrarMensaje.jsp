<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/styleTable.css" />
<head>
<title>ShareMyTrip</title>
</head>
<body>

	<div class="fondo">
		<h1 align="center">${plaza}</h1>
		
		<br/>
		<br/>
		<center>
			<p class="enlaces_plaza_viaje">
				<a href="solicitudes">Volver a mis Solicitudes</a>
			</p>
			<p class="enlaces_plaza_viaje">
				<a href="modificarDatos">Inicio</a>
			</p>
		</center>

	</div>
	
</body>
</html>