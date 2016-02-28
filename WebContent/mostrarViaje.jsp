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
			<td>ID viaje</td>
			<td>${trip.id}</td>
		</tr>
		<tr>
			<td>Ciudad de salida</td>
			<td>${trip.departure.city}</td>
		</tr>
		<tr>
			<td>Dirección de salida</td>
			<td>${trip.departure.address}</td>
		</tr>
		<tr>
			<td>Provincia de salida</td>
			<td>${trip.departure.state}</td>
		</tr>
		<tr>
			<td>País de salida</td>
			<td>${trip.departure.country}</td>
		</tr>
		<tr>
			<td>Código Postal de la salida</td>
			<td>${trip.departure.zipCode}</td>
		</tr>
		<tr>
			<td>Coordenadas latitud salida</td>
			<td>${trip.departure.waypoint.lat}</td>
		</tr>
		<tr>
			<td>Coordenadas longitud salida</td>
			<td>${trip.departure.waypoint.lon}</td>
		</tr>
	
		<tr>
			<td>Ciudad de llegada</td>
			<td>${trip.destination.city}</td>
		</tr>
		<tr>
			<td>Dirección de llegada</td>
			<td>${trip.destination.address}</td>
		</tr>
		<tr>
			<td>Provincia de llegada</td>
			<td>${trip.destination.state}</td>
		</tr>
		<tr>
			<td>País de llegada</td>
			<td>${trip.destination.country}</td>
		</tr>
		<tr>
			<td>Código Postal de la llegada</td>
			<td>${trip.destination.zipCode}</td>
		</tr>
		<tr>
			<td>Coordenadas latitud llegada</td>
			<td>${trip.destination.waypoint.lat}</td>
		</tr>
		<tr>
			<td>Coordenadas longitud llegada</td>
			<td>${trip.destination.waypoint.lon}</td>
		</tr>
		
		<tr>
			<td>Fecha de la salida</td>
			<td>${trip.departureDate}</td>
		</tr>
		<tr>
			<td>Fecha de la llegada</td>
			<td>${trip.arrivalDate}</td>
		</tr>
		<tr>
			<td>Fecha límite</td>
			<td>${trip.closingDate}</td>
		</tr>
		<tr>
			<td>Plazas totales</td>
			<td>${trip.maxPax}</td>
		</tr>
		<tr>
			<td>Plazas libres</td>
			<td>${trip.availablePax}</td>
		</tr>
		<tr>
			<td>Coste estimado</td>
			<td>${trip.estimatedCost}</td>
		</tr>			
		<tr>
			<td>Comentarios</td>
			<td>${trip.comments}</td>
		</tr>
		<tr>
			<td>Promotor</td>
			<td>${user.name}</td>
		</tr>
		
	</table>
	
	<br>
	<center>
		<a href="solicitarViaje?id=${trip.id}">Solicitar viaje</a>
	</center>
	
</body>
</html>