package main.java.es.uniovi.asw.persistencia;

public class Generador {

	public void generarCarta(Votante votante) {
		
		FileWriter carta = new FileWriter (obtenerNombreFichero(votante) + ".txt");
		
		carta.println("Usuario: " + generarUsuario(votante));
		carta.println("Contraseña: " + generarPassword(votante));
		
		carta.close();
	}
	
	private String obtenerNombreFichero(Votante votante) {
		
		return votante.getNif();
	}

	private String generarUsuario(Votante votante) {
		
		return votante.getNombre() + "." + votante.getEmail();
	}
}