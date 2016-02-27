<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Registrar Viaje</title>
<body>
	<form action="registrarViaje" method="post">
		<center>
			<h1>Registrar viaje</h1>
		</center>
		<hr>
		<br>
		<table align="center">
			<tr>
				<td>Ciudad de SALIDA</td>
				<td><input type="text" name="ciudadSalida" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Dirección</td>
				<td><input type="text" name="direccionSalida" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Provincia</td>
				<td><input type="text" name="provinciaSalida" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>País</td>
				<td><input type="text" name="paisSalida" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Código Postal</td>
				<td><input type="text" name="CPSalida" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Coordenadas: latitud (Opcional)</td>
				<td><input type="text" name="latSalida" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Coordenadas: longitud (Opcional)</td>
				<td><input type="text" name="lonSalida" align="left"
					size="15"></td>
			</tr>
		</table>
		<br/><br/>
		<table align="center">
			<tr>
				<td>Ciudad de LLEGADA</td>
				<td><input type="text" name="ciudadLlegada" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Dirección</td>
				<td><input type="text" name="direccionLlegada" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Provincia</td>
				<td><input type="text" name="provinciaLlegada" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>País</td>
				<td><input type="text" name="paisLlegada" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Código Postal</td>
				<td><input type="text" name="CPLlegada" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Coordenadas: latitud (Opcional)</td>
				<td><input type="text" name="latLlegada" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Coordenadas: longitud (Opcional)</td>
				<td><input type="text" name="lonLlegada" align="left"
					size="15"></td>
			</tr>
		</table>
		<br/><br/>
		<p align="center">Formato de las fechas: 10/12/2010 15:00</p>
		<table align="center">
			<tr>
				<td>Fecha Salida</td>
				<td><input type="text" name="fechaSalida" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Fecha Llegada</td>
				<td><input type="text" name="fechaLlegada" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Fecha Límite</td>
				<td><input type="text" name="fechaLimite" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Plazas totales</td>
				<td><input type="text" name="plazasTotal" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Plazas libres</td>
				<td><input type="text" name="plazasLibres" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Coste estimado</td>
				<td><input type="text" name="coste" align="left"
					size="15"></td>
			</tr>
			<tr>
				<td>Comentarios</td>
				<td><input type="text" name="comentarios" align="left"
					size="15"></td>
			</tr>
			
		</table>
		<br>
		<center>
			<input type="submit" value="Registrar Viaje" />
		</center>
	</form>
</body>
</html>

