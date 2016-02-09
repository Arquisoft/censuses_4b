import java.io.*;

import main.java.es.uniovi.asw.logica.Votante;

public class Generador {

	public void generarCarta(Votante votante) throws FileNotFoundException {
		
		PrintWriter carta = new PrintWriter (obtenerNombreFichero(votante) + ".txt");
		
		carta.println("Usuario: " + generarUsuario(votante));
		carta.println("Contraseña: " + generarPassword(votante));
		
		carta.close();
	}
	
	private String generarPassword(Votante votante) {
		// TODO Auto-generated method stub
		return null;
	}

	private String obtenerNombreFichero(Votante votante) {
		
		return votante.getNif();
	}

	private String generarUsuario(Votante votante) {
		
		return votante.getNombre() + "." + votante.getEmail();
	}
}