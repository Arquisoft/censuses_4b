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
		<h1 align="center">Mis viajes</h1>

		<table class="tabla_misViajes" border="1" align="center">
			<tr>
				<th>Origen</th>
				<th>Destino</th>
				<th>Fecha de salida</th>
				<th>Fecha de llegada</th>
				<th>Usuario</th>
				<th>Cancelar viaje</th>
			</tr>
			<c:forEach var="entry" items="${mapViajes}" varStatus="i">
				<c:forEach var="entry2" items="${entry.value}" varStatus="i">
					<tr id="item_${i.index}">
						<td>${entry2.value.departure.city}</td>
						<td>${entry2.value.destination.city}</td>
						<td>${entry2.value.departureDate}</td>
						<td>${entry2.value.arrivalDate}</td>
						<td>${entry2.key}</td>
						<td class="check"><a
							href="cancelarViaje?tripId=${entry2.value.id}">&#x2713;</a></td>
					</tr>
				</c:forEach>
			</c:forEach>
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