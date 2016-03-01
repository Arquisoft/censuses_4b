<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/styleTable.css" />
<head>
<title>ShareMyTrip - Mi listado de viajes</title>
<script type="text/javascript" src="css/jquery-1.12.1.js"></script>
<script type="text/javascript" src="css/jquery.tablesorter.js"></script>

<script type="text/javascript">
$(document).ready(function()
    {
        $("#myTable1").tablesorter();
        $("#myTable2").tablesorter();
    }
);
</script>
</head>
<body>

	<div class="fondo">
	
		<form action="filtro?id=solicitudes" method="post">
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
	
		<h1 align="center">Solicitudes en mis viajes</h1>

		<table class="tabla_misViajes" border="1" align="center" id="myTable1">
		<thead>
			<tr>
				<th>Origen</th>
				<th>Destino</th>
				<th>Salida</th>
				<th>Llegada</th>
				<th>Plazas libres</th>
				<th>Usuario</th>
				<th>Estado</th>
				<th>Confirmar</th>
				<th>Rechazar</th>
			</tr>
			</thead>
		<tbody>
			<c:if test="${mapViajes == null}">
				<tr><td colspan="9">Sin solicitudes</td></tr>
			</c:if>
			
			<c:forEach var="entry" items="${mapViajes}" varStatus="i">
				<c:forEach var="entry2" items="${entry.value}" varStatus="j">
					<tr id="item_${i.index}">
						
						<td>${entry2.value.departure.city}</td>
						<td>${entry2.value.destination.city}</td>
						<td>${entry2.value.departureDate}</td>
						<td>${entry2.value.arrivalDate}</td>
						<td>${entry2.value.availablePax}</td>
						
						<td>${solicitante[i.index].userId}</td>
						<td>${solicitante[i.index].status}</td>
					
						<td class="check"><a href="aceptarPlaza?seat=${entry2.value.id}&solicitante=${solicitante[i.index].userId}">&#x2713;</a></td>
						<td class="check"><a href="rechazarPlaza?seat=${entry2.value.id}&solicitante=${solicitante[i.index].userId}">X</a></td>
						
					</tr>
				</c:forEach>
			</c:forEach>
			</tbody>
		</table>
		
		<h1 align="center">Historial</h1>
		
		<table class="tabla_misViajes" border="1" align="center" id="myTable2">
		<thead>
			<tr>
				<th>Origenes</th>
				<th>Destino</th>
				<th>Fecha de salida</th>
				<th>Fecha de llegada</th>
				<th>Estado</th>
				<th>Promotor</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${mapViajesMnp == null}">
				<tr><td colspan="6">Sin historial</td></tr>
			</c:if>
			
			<c:forEach var="entry" items="${mapViajesMnp}" varStatus="i">
				<c:forEach var="entry2" items="${entry.value}" varStatus="j">
					<tr id="item_${i.index}">
						
						<td>${entry2.value.departure.city}</td>
						<td>${entry2.value.destination.city}</td>
						<td>${entry2.value.departureDate}</td>
						<td>${entry2.value.arrivalDate}</td>
						<td>${promotores[i.index].status}</td>
						
						<td>${entry2.value.promoterId}</td>
					
					</tr>
				</c:forEach>
			</c:forEach>
		</tbody>
		</table>
		

		<div class="mostrar_viaje_mensaje">
			<center>
				<c:if test="${requestScope.mensaje!=null}">
					<c:out value="${requestScope.mensaje}" />
				</c:if>
			</center>
		</div>

		<input type="button" onclick="history.back()" name="volver_atras"
			value="&#8617;">

	</div>
	
</body>
</html>