<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarNavegacion.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/stylePrincipal.css" />
<head>
<title>ShareMyTrip - Página principal del usuario</title>

</head>
<body>
	<div class="fondo">
		<ul id="menu">
			<li><a id="listarViajes" href="listarViajes">Viajes
					ofertados</a></li>
			<li><a id="historialViajes" href="historialViajes">Historial
					de viajes</a></li>
			<li><a id="mostrarMisViajes" href="mostrarMisViajes">Mis
					viajes</a></li>
			<li><a id="registroViaje" href="registroViaje">Registrar
					viaje</a></li>
			<li><a id="solicitudes" href="solicitudes">Solicitudes</a></li>
			<li><a id="validarse" href="validarse"> Cerrar Sesión</a></li>
		</ul>

		<div class="contenedor_inicio">
			<jsp:useBean id="user" class="uo.sdi.model.User" scope="session" />
			<table>
				<tr>
					<td class="principal_login">Login:</td>
					<td id="login"><jsp:getProperty property="login" name="user" /></td>
				</tr>
				<tr>
					<td class="principal_name">Nombre:</td>
					<td id="name"><form action="modificarDatos" method="POST">
							<input type="text" name="name" size="10"
								value="<jsp:getProperty property="name" name="user" />">
							<input type="submit" value="Modificar">
						</form></td>
				</tr>
				<tr>
					<td class="principal_surname">Apellidos:</td>
					<td id="surname"><form action="modificarDatos" method="POST">
							<input type="text" name="surname" size="15"
								value="<jsp:getProperty property="surname" name="user" />">
							<input type="submit" value="Modificar">
						</form></td>
				</tr>
				<tr>
					<td class="principal_email">Email:</td>
					<td id="email"><form action="modificarDatos" method="POST">
							<input type="text" name="email" size="20"
								value="<jsp:getProperty property="email" name="user"/>">
							<input type="submit" value="Modificar">
						</form></td>
				</tr>

				<tr>
					<td class="principal_passwd">Contraseña:</td>
					<td id="passwd"><form action="modificarDatos" method="POST">
							<input type="password" name="passwdAntigua" size="10" value="">
							<label for="nombrePass">Nueva contraseña: </label> <input
								type="password" name="passwd" size="10" value=""> <label
								for="repetirPass">Repita su contraseña: </label> <input
								type="password" name="passwd2" size="10" value=""> <input
								type="submit" value="Modificar">
						</form></td>
				</tr>

			</table>
			<br>
			<div class="principal_mensaje">
				<center>
					<c:if test="${requestScope.mensaje!=null}">
						<c:out value="${requestScope.mensaje}" />
					</c:if>
				</center>
			</div>
			<br /> <br /> <label for="contador">Es Vd el usuario
				número: ${contador}</label>
		</div>
	</div>
</body>
</html>
