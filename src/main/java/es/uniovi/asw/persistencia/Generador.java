package main.java.es.uniovi.asw.persistencia;

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

		String pass = votante.getNombre() + "." + votante.getNif();
		
		pass += generarValoresClave();
		
		return pass;
	}

	private String generarValoresClave() {

		int i, valor;
		char[] codigo = new char[5];
		char[] elementos = {'0','1','2','3','4','5','6','7','8','9',
						'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
						'ñ','o','p','q','r','s','t','u','v','w','x','y','z',
						'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
						'Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z',
						'*','+','.',',','ç','Ç'};
		
		for(i = 0; i < codigo.length; i++){
			valor = (int)(Math.random() * elementos.length);
			codigo[i] = (char)elementos[valor];
		}
		
		return new String(codigo);
	}

	private String obtenerNombreFichero(Votante votante) {
		
		return votante.getNif();
	}

	private String generarUsuario(Votante votante) {
		
		return votante.getNombre() + "." + votante.getEmail();
	}	
}