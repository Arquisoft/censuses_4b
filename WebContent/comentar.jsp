<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/styleTable.css" />
<head>
<title>ShareMyTrip - Mi listado de viajes</title>
</head>
<body>

	<div class="fondo">
	
		<h1 align="center">Participantes del viaje</h1>

		<table class="tabla_misViajes" border="1" align="center">
		<thead>
			<tr>
				<th>Usuario</th>
				<th>Rol</th>
				<th>Valoración</th>
			</tr>
			</thead>
		<tbody>
			<c:forEach var="entry" items="${seats}" varStatus="i">
				<tr id="item_${i.index}">
					
					<td>${users[i.index].login}</td>
					<td>${entry.status}</td>
					<td></a></td>
					
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<input type="button" onclick="history.back()" name="volver_atras"
			value="&#8617;">
	
		<p align="right">
			<a href="modificarDatos"><img src="img/inicio.png" width="80" ></a>
		</p>
	</div>
	
</body>
</html>