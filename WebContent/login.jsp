<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<head>
<title>ShareMyTrip - Inicie sesión</title>
<body>
	<div class="fondo">
		<div class="contenedor_inicio">
			<div class="login">
				<div class="login__form">
					<form action="validarse" method="post">
						<center>
							<h1>Inicie sesión</h1>
						</center>
						<hr>
						<br>
						<table align="center">
							<tr>
								<td align="right" class="login_id">Su identificador de
									usuario</td>
								<td><input type="text" name="nombreUsuario" align="left"
									size="15"></td>
							</tr>
						</table>
						<br>
						<center>
							<input type="submit" class="login__submit" value="Enviar" />
						</center>
						
					</form>
					<br>

					<center>
						<p class="login_registrarse">
							<a id="registrarse" href="registrarse.jsp">Registrarse</a>
						</p>
						<br>
						<p class="login_listarViajes">
							<a id="listarViajes" href="listarViajes">Lista de viajes</a>
						</p>
					</center>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

