<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/styleTable.css" />
<head>
<title>ShareMyTrip - Listado de viajes</title>
<script type="text/javascript" src="css/jquery-1.12.1.js"></script>
<script type="text/javascript" src="css/jquery.tablesorter.js"></script>

<script type="text/javascript">
$(document).ready(function()
    {
        $("#myTable").tablesorter();
    }
);
</script>
</head>
<body>

	<div class="fondo">
	
		<form action="filtro?id=lista" method="post">
			<table align="center" class="tablaFiltros">
			<thead>
				<tr>
					<th>Origen</th>
					<th><input type="text" name="origen" align="left"
									size="15"></th>
					<th>Destino</th>
					<th><input type="text" name="destino" align="left"
									size="15"></th>
					<th><input type="submit" class="botonFiltros" value="Buscar" /></th>
				</tr>
			</thead>
			</table>
		</form>
	
		<h1 align="center">Lista de viajes</h1>

		<table border="1" align="center" id="myTable">
		<thead>
			<tr>
				<th>ID viaje</th>
				<th>Origen</th>
				<th>Destino</th>
				<th>Plazas libres</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entry" items="${listaViajes}" varStatus="i">
				<tr id="item_${i.index}">
					<td><a href="mostrarViaje?id=${entry.id}">${entry.id}</a></td>
					<td>${entry.departure.city}</td>
					<td>${entry.destination.city}</td>
					<td>${entry.availablePax}</td>
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