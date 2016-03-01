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
				<br />
				<br />
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
				<br />
				<br />
				<p class="formato_fechas" align="center">Formato de las fechas: 10/12/2010 15:00</p>
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
						<center><c:out value="${requestScope.mensajeViaje}" /></center>
					</c:if>
			
				</center>
			</div>	
			
			<input type="button" onclick="history.back()" name="volver_atras"
			value="&#8617;">
			
			<p align="right">
			<a href="modificarDatos"><img src="img/inicio.png" width="80" ></a>
		</p>
	</div>
</body>
</html>

