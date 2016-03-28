<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<link rel="stylesheet" type="text/css"
	href="css/styleRegistrarViaje.css" />
<head>
<title>ShareMyTrip - Registrar Viaje</title>
<body>
	<div class="fondo">
		<div class="contenedor_inicio">
			<form action="registrarViaje" method="post">
				<center>
					<h1>Registrar viaje</h1>
				</center>
				<hr>

				<table align="center">
					<tr>
						<td class="ciudad_salida">Ciudad de SALIDA:</td>
						<td><input type="text" name="ciudadSalida" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="dir_salida">Dirección:</td>
						<td><input type="text" name="direccionSalida" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="provincia_salida">Provincia:</td>
						<td><input type="text" name="provinciaSalida" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="pais_salida">País:</td>
						<td><input type="text" name="paisSalida" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="cod_salida">Código Postal:</td>
						<td><input type="text" name="CPSalida" align="left" size="15"></td>
					</tr>
					<tr>
						<td class="lat_salida">Coordenadas: latitud (Opcional):</td>
						<td><input type="text" name="latSalida" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="long_salida">Coordenadas: longitud (Opcional):</td>
						<td><input type="text" name="lonSalida" align="left"
							size="15"></td>
					</tr>
				</table>
				<br /> <br />
				<table align="center">
					<tr>
						<td class="ciudad_llegada">Ciudad de LLEGADA:</td>
						<td><input type="text" name="ciudadLlegada" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="dir_llegada">Dirección:</td>
						<td><input type="text" name="direccionLlegada" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="provincia_llegada">Provincia:</td>
						<td><input type="text" name="provinciaLlegada" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="pais_llegada">País:</td>
						<td><input type="text" name="paisLlegada" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="cod_llegada">Código Postal:</td>
						<td><input type="text" name="CPLlegada" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="lat_llegada">Coordenadas: latitud (Opcional):</td>
						<td><input type="text" name="latLlegada" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="long_llegada">Coordenadas: longitud (Opcional):</td>
						<td><input type="text" name="lonLlegada" align="left"
							size="15"></td>
					</tr>
				</table>
				<br /> <br />
				<p class="formato_fechas" align="center">Formato de las fechas:
					10/12/2010 15:00</p>
				<table align="center">
					<tr>
						<td class="fecha_salida">Fecha Salida:</td>
						<td><input type="text" name="fechaSalida" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="fecha_llegada">Fecha Llegada:</td>
						<td><input type="text" name="fechaLlegada" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="fecha_limite">Fecha Límite:</td>
						<td><input type="text" name="fechaLimite" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="plazas_totales">Plazas totales:</td>
						<td><input type="text" name="plazasTotal" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="plazas_libres">Plazas libres:</td>
						<td><input type="text" name="plazasLibres" align="left"
							size="15"></td>
					</tr>
					<tr>
						<td class="coste">Coste estimado:</td>
						<td><input type="text" name="coste" align="left" size="15"></td>
					</tr>
					<tr>
						<td class="comentarios">Comentarios:</td>
						<td><input type="text" name="comentarios" align="left"
							size="15"></td>
					</tr>

				</table>
				<br>
				<center>
					<input type="submit" value="Registrar Viaje" />
				</center>
			</form>

		</div>

		<div class="reg_mensaje">
			<center>
				<c:if test="${mensajeViaje != null}">
					<center>
						<c:out value="${requestScope.mensajeViaje}" />
					</center>
				</c:if>

			</center>
		</div>

		<input type="button" onclick="history.back()" name="volver_atras"
			value="&#8617;"> <a id="icon_home" href="modificarDatos"><img
			src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTYuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgd2lkdGg9IjY0cHgiIGhlaWdodD0iNjRweCIgdmlld0JveD0iMCAwIDYzLjY5OSA2My42OTkiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDYzLjY5OSA2My42OTk7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4KPGc+Cgk8cGF0aCBkPSJNNjMuNjYzLDI5LjQyNGMtMC4xNDMtMS4wOTMtMC43MDEtMi4wNjUtMS41NzUtMi43MzdsLTExLjcxNS05LjAyMVY4LjYwOGMwLTIuMjc1LTEuODUxLTQuMTI2LTQuMTI1LTQuMTI2ICAgYy0yLjI3MywwLTQuMTI1LDEuODUxLTQuMTI1LDQuMTI2djIuNzA1bC03Ljc1OC01Ljk3NWMtMC43MTgtMC41NTEtMS42MTItMC44NTYtMi41MTctMC44NTZjLTAuOTA2LDAtMS44MDEsMC4zMDQtMi41MTksMC44NTcgICBMMS42MDYsMjYuNjg3Yy0xLjgwMiwxLjM4OS0yLjEzOSwzLjk4My0wLjc1MSw1Ljc4NWMwLjc4OCwxLjAyMiwxLjk3OSwxLjYwOCwzLjI3MSwxLjYwOGMwLjY2NCwwLDEuMzAyLTAuMTUzLDEuODgtMC40NTFWNTUuMDkgICBjMCwyLjI3NSwxLjg1MSw0LjEyNyw0LjEyNiw0LjEyN2gxOC41MzRWMzkuNzMyaDYuMzUxdjE5LjQ4MmgxOC4yNzFjMi4yNzQsMCw0LjEyNS0xLjg1LDQuMTI1LTQuMTI3VjMzLjQ3MiAgIGMwLjY0OSwwLjM5OSwxLjM4NywwLjYwOCwyLjE1NywwLjYwOGMxLjI4OSwwLDIuNDgyLTAuNTg2LDMuMjctMS42MDZDNjMuNTE0LDMxLjYwMSw2My44MDcsMzAuNTE4LDYzLjY2MywyOS40MjR6IE01OS44MTksMzAuMTQ0ICAgYy0wLjA4LDAuMTA1LTAuMTg5LDAuMTIyLTAuMjQ3LDAuMTIyYy0wLjA2OSwwLTAuMTMyLTAuMDIxLTAuMTg4LTAuMDY1TDUzLjYsMjUuNzQ4VjU1LjA5YzAsMC4xNzMtMC4xNCwwLjMxMi0wLjMxMSwwLjMxMkgzOC44MzIgICBsMC4wMDEtMTkuNDg0SDI0Ljg1MnYxOS40ODRIMTAuMTMyYy0wLjE3MSwwLTAuMzEtMC4xNDEtMC4zMS0wLjMxMlYyNS45Nkw0LjMxNSwzMC4yYy0wLjA1NiwwLjA0My0wLjExOSwwLjA2NS0wLjE4OCwwLjA2NSAgIGMtMC4wNTksMC0wLjE2Ny0wLjAxNy0wLjI0OC0wLjEyMWMtMC4wNjUtMC4wODQtMC4wNy0wLjE3MS0wLjA2Mi0wLjIyOWMwLjAwNy0wLjA1OCwwLjAzNC0wLjE0MSwwLjExOC0wLjIwNUwzMS42NjEsOC4zNjMgICBjMC4xMzgtMC4xMDUsMC4yMzktMC4xMDYsMC4zNzksMGwxMy44OTksMTAuNzAzVjguNjA4YzAtMC4xNzIsMC4xNC0wLjMxMSwwLjMxMS0wLjMxMXMwLjMxMiwwLjEzOSwwLjMxMiwwLjMxMXYxMC45MzUgICBsMTMuMjA1LDEwLjE2NmMwLjA4NCwwLjA2NCwwLjEwOCwwLjE0NywwLjExNiwwLjIwNUM1OS44OTEsMjkuOTc1LDU5Ljg4NSwzMC4wNjIsNTkuODE5LDMwLjE0NHoiIGZpbGw9IiNGRkZGRkYiLz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K" /></a>

	</div>
</body>
</html>

