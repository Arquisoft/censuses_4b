<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Mostrar viajes</title>
</head>
<body>

	<h1 align="center">Detalles del viaje ${trip.departure.city} - ${trip.destination.city}</h1>

	<table border="1" align="center">
			<tr>
				<th>ID viaje</th>
				<th>Origen</th>
				<th>Destino</th>
				<th>Fecha</th>
				<th>Estado</th>
			</tr>
		<c:forEach var="entry" items="${listaViajes}" varStatus="i">
			<tr id="item_${i.index}">
				<td>${trip.id}</td>
				<td>${trip.departure.city}</td>
				<td>${trip.destination.city}</td>
				<td>${trip.departureDate}</td>
				<td>${seat.seatstatus}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<center>
		<a href="solicitarViaje">Solicitar viaje</a>
	</center>
	
</body>
</html>