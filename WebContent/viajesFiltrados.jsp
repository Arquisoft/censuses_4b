<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/styleTable.css" />
<head>
<title>ShareMyTrip - Mostrar viajes</title>
<script type="text/javascript" src="css/jquery-1.12.1.js"></script>
<script type="text/javascript" src="css/jquery.tablesorter.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
	});
</script>
</head>
<body>

	<div class="fondo">

		<form action="filtro?id=${id}" method="post">
			<table align="center" class="tablaFiltros">
				<thead>
					<tr>
						<th>Origen</th>
						<th><input type="text" name="origen" align="left" size="15"></th>
						<th>Destino</th>
						<th><input type="text" name="destino" align="left" size="15"></th>
						<th><input type="submit" class="botonFiltros" value="Buscar" /></th>
					</tr>
				</thead>
			</table>
		</form>

		<h1 align="center">Lista de viajes</h1>

		<c:if test="${id.equals('historial')}">
			<table border="1" align="center" id="myTable">
				<thead>
					<tr>
						<th>ID viaje</th>
						<th>Origen</th>
						<th>Destino</th>
						<th>Plazas libres</th>
						<th>Opiniones</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${viajesValidos == null}">
						<tr>
							<td colspan="5">Sin coincidencias</td>
						</tr>
					</c:if>
					<c:forEach var="entry" items="${viajesValidos}" varStatus="i">
						<tr id="item_${i.index}">
							<td><a href="mostrarViaje?id=${entry.id}">${entry.id}</a></td>
							<td>${entry.departure.city}</td>
							<td>${entry.destination.city}</td>
							<td>${entry.availablePax}</td>
							<td>${entry.comments}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${id.equals('lista')}">
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
					<c:if test="${viajesValidos == null}">
						<tr>
							<td colspan="4">Sin coincidencias</td>
						</tr>
					</c:if>
					<c:forEach var="entry" items="${viajesValidos}" varStatus="i">
						<tr id="item_${i.index}">
							<td><a href="mostrarViaje?id=${entry.id}">${entry.id}</a></td>
							<td>${entry.departure.city}</td>
							<td>${entry.destination.city}</td>
							<td>${entry.availablePax}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${id.equals('misViajes')}">
			<table border="1" align="center" id="myTable">
				<thead>
					<tr>
						<th>Detalles</th>
						<th>Origen</th>
						<th>Destino</th>
						<th>Salida</th>
						<th>Llegada</th>
						<th>Usuario</th>
						<th>Cancelar</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${viajesValidos == null}">
						<tr>
							<td colspan="7">Sin coincidencias</td>
						</tr>
					</c:if>
					<c:forEach var="entry" items="${mapViajes}" varStatus="i">
						<c:forEach var="entry2" items="${entry.value}" varStatus="i">
							<tr id="item_${i.index}">
								<td><a href="mostrarViaje?id=${entry2.value.id}">Detalles</a></td>
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
				</tbody>
			</table>
		</c:if>

		<c:if test="${id.equals('solicitudes')}">
			<table border="1" align="center" id="myTable">
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
						<tr>
							<td colspan="9">Sin coincidencias</td>
						</tr>
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

								<td class="check"><a
									href="aceptarPlaza?seat=${entry2.value.id}&solicitante=${solicitante[i.index].userId}">&#x2713;</a></td>
								<td class="check"><a
									href="rechazarPlaza?seat=${entry2.value.id}&solicitante=${solicitante[i.index].userId}">X</a></td>

							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>

			<br />
			<h1 align="center">Historial</h1>

			<table class="tabla_misViajes" border="1" align="center"
				id="myTable2">
				<thead>
					<tr>
						<th>Origenes</th>
						<th>Destino</th>
						<th>Fecha de salida</th>
						<th>Fecha de llegada</th>
						<th>Estado</th>
						<th>Promotor</th>
						<th>Valoraciones</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${mapViajesMnp == null}">
						<tr>
							<td colspan="6">Sin historial</td>
						</tr>
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
								<td><a href="comentar?id=${entry2.value.id}">Valoraciones</a></td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>

		</c:if>

		<input type="button" onclick="history.back()" name="volver_atras"
			value="&#8617;"> <a id="icon_home" href="modificarDatos"><img
			src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTYuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgd2lkdGg9IjY0cHgiIGhlaWdodD0iNjRweCIgdmlld0JveD0iMCAwIDYzLjY5OSA2My42OTkiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDYzLjY5OSA2My42OTk7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4KPGc+Cgk8cGF0aCBkPSJNNjMuNjYzLDI5LjQyNGMtMC4xNDMtMS4wOTMtMC43MDEtMi4wNjUtMS41NzUtMi43MzdsLTExLjcxNS05LjAyMVY4LjYwOGMwLTIuMjc1LTEuODUxLTQuMTI2LTQuMTI1LTQuMTI2ICAgYy0yLjI3MywwLTQuMTI1LDEuODUxLTQuMTI1LDQuMTI2djIuNzA1bC03Ljc1OC01Ljk3NWMtMC43MTgtMC41NTEtMS42MTItMC44NTYtMi41MTctMC44NTZjLTAuOTA2LDAtMS44MDEsMC4zMDQtMi41MTksMC44NTcgICBMMS42MDYsMjYuNjg3Yy0xLjgwMiwxLjM4OS0yLjEzOSwzLjk4My0wLjc1MSw1Ljc4NWMwLjc4OCwxLjAyMiwxLjk3OSwxLjYwOCwzLjI3MSwxLjYwOGMwLjY2NCwwLDEuMzAyLTAuMTUzLDEuODgtMC40NTFWNTUuMDkgICBjMCwyLjI3NSwxLjg1MSw0LjEyNyw0LjEyNiw0LjEyN2gxOC41MzRWMzkuNzMyaDYuMzUxdjE5LjQ4MmgxOC4yNzFjMi4yNzQsMCw0LjEyNS0xLjg1LDQuMTI1LTQuMTI3VjMzLjQ3MiAgIGMwLjY0OSwwLjM5OSwxLjM4NywwLjYwOCwyLjE1NywwLjYwOGMxLjI4OSwwLDIuNDgyLTAuNTg2LDMuMjctMS42MDZDNjMuNTE0LDMxLjYwMSw2My44MDcsMzAuNTE4LDYzLjY2MywyOS40MjR6IE01OS44MTksMzAuMTQ0ICAgYy0wLjA4LDAuMTA1LTAuMTg5LDAuMTIyLTAuMjQ3LDAuMTIyYy0wLjA2OSwwLTAuMTMyLTAuMDIxLTAuMTg4LTAuMDY1TDUzLjYsMjUuNzQ4VjU1LjA5YzAsMC4xNzMtMC4xNCwwLjMxMi0wLjMxMSwwLjMxMkgzOC44MzIgICBsMC4wMDEtMTkuNDg0SDI0Ljg1MnYxOS40ODRIMTAuMTMyYy0wLjE3MSwwLTAuMzEtMC4xNDEtMC4zMS0wLjMxMlYyNS45Nkw0LjMxNSwzMC4yYy0wLjA1NiwwLjA0My0wLjExOSwwLjA2NS0wLjE4OCwwLjA2NSAgIGMtMC4wNTksMC0wLjE2Ny0wLjAxNy0wLjI0OC0wLjEyMWMtMC4wNjUtMC4wODQtMC4wNy0wLjE3MS0wLjA2Mi0wLjIyOWMwLjAwNy0wLjA1OCwwLjAzNC0wLjE0MSwwLjExOC0wLjIwNUwzMS42NjEsOC4zNjMgICBjMC4xMzgtMC4xMDUsMC4yMzktMC4xMDYsMC4zNzksMGwxMy44OTksMTAuNzAzVjguNjA4YzAtMC4xNzIsMC4xNC0wLjMxMSwwLjMxMS0wLjMxMXMwLjMxMiwwLjEzOSwwLjMxMiwwLjMxMXYxMC45MzUgICBsMTMuMjA1LDEwLjE2NmMwLjA4NCwwLjA2NCwwLjEwOCwwLjE0NywwLjExNiwwLjIwNUM1OS44OTEsMjkuOTc1LDU5Ljg4NSwzMC4wNjIsNTkuODE5LDMwLjE0NHoiIGZpbGw9IiNGRkZGRkYiLz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K" /></a>


	</div>

</body>
</html>