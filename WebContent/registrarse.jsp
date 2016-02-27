<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<head>

<title>ShareMyTrip - Registrarse</title>
<body>
	<div class="fondo">
		<div class="contenedor_inicio">
			<div class="login">
				<div class="login__form">
					<form action="registrarse" method="post">
						<center>
							<h1>Registrarse</h1>
						</center>
						<hr>
						<br>
						<table align="center">


							<tr>
								<td align="right" class="reg_nombre">Introduzca su nombre</td>
								<td><input type="text" name="nombre" align="left" size="15"></td>
							</tr>

							<tr>
								<td align="right" class="reg_apellido">Introduzca sus
									apellidos</td>
								<td><input type="text" name="apellidos" align="left"
									size="15"></td>
							</tr>

							<tr>
								<td align="right" class="reg_email">Introduzca su email</td>
								<td><input type="text" name="emailUsuario" align="left"
									size="15"></td>
							</tr>


							<tr>
								<td align="right" class="reg_id">Su identificador de
									usuario</td>
								<td><input type="text" name="idUsuario" align="left"
									size="15"></td>
							</tr>

							<tr>
								<td align="right" class="reg_psswd">Su contraseña de
									usuario</td>
								<td><input type="password" name="passwd" align="left"
									size="15"></td>
							</tr>

							<tr>
								<td align="right" class="reg_psswd2">Repita su contraseña</td>
								<td><input type="password" name="passwd2" align="left"
									size="15"></td>
							</tr>

						</table>
						<br>

						<center>
							<input type="submit" class="reg_submit" value="Registrarse" />
						</center>

					</form>
					<br>

					<div class="reg_mensaje">
						<center>
							<c:if test="${requestScope.mensaje!=null}">
								<c:out value="${requestScope.mensaje}" />
							</c:if>
						</center>
					</div>
					<input type="button" class="icono_return" onclick="history.back()"
						name="volver_atras" value="&#8617;">
				</div>
			</div>
		</div>
	</div>
</body>
</html>