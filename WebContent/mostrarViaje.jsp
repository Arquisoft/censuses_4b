<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/styleTable.css" />
<head>
<title>ShareMyTrip - Mostrar viajes</title>
</head>
<body>

	<div class="fondo">
		<h1 align="center">Detalles del viaje ${trip.departure.city} -
			${trip.destination.city}</h1>


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


			<c:forEach var="entry" items="${mapseat}" varStatus="i">
				<c:forEach var="entry2" items="${entry.value}" varStatus="i">
					<tr>
						<td>${entry2.key}</td>
						<td>${entry2.value.login}</td>
					</tr>
				</c:forEach>
			</c:forEach>


		</table>

		<br>


		<center>
			<p class="enlaces_plaza_viaje">
				<a href="solicitarViaje?id=${trip.id}">Solicitar viaje </a> &nbsp;
				&nbsp; &nbsp; <a href="cancelarViaje?id=${trip.id}">Cancelar
					viaje</a>
			</p>
		</center>


		<br>
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