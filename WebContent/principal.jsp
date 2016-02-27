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

		<ul id="menu">
			<li><a href="listarViajes">Lista de viajes</a></li>
			<li><a href="registroViaje">Registrar
					viaje</a></li>
		</ul>


		<jsp:useBean id="user" class="uo.sdi.model.User" scope="session" />
		<table>
			<tr>
				<td>Login:</td>
				<td id="login"><jsp:getProperty property="login" name="user" /></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td id="name"><form action="modificarDatos" method="POST">
						<input type="text" name="name" size="10"
							value="<jsp:getProperty property="name" name="user" />">
						<input type="submit" value="Modificar">
					</form></td>
			</tr>
			<tr>
				<td>Apellidos:</td>
				<td id="surname"><form action="modificarDatos" method="POST">
						<input type="text" name="surname" size="15"
							value="<jsp:getProperty property="surname" name="user" />">
						<input type="submit" value="Modificar">
					</form></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td id="email"><form action="modificarDatos" method="POST">
						<input type="text" name="email" size="20"
							value="<jsp:getProperty property="email" name="user"/>">
						<input type="submit" value="Modificar">
					</form></td>
			</tr>

			<tr>
				<td>Contraseña:</td>
				<td id="passwd"><form action="modificarDatos" method="POST">
						<input type="password" name="passwdAntigua" size="10" value="">
						Nueva contraseña: <input type="password" name="passwd" size="10"
							value=""> Repita su nueva contraseña: <input
							type="password" name="passwd2" size="10" value=""> <input
							type="submit" value="Modificar">
					</form></td>
			</tr>

		</table>


	<c:if test="${requestScope.mensaje!=null}">
		<c:out value="${requestScope.mensaje}" />
	</c:if>
	<br />



	<br /> Es Vd el usuario número: ${contador}
</body>
</html>
