package es.uniovi.asw;

import java.util.logging.Logger;

import es.uniovi.asw.parser.LeerFichero;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {
	

	public static void main(String... args) {
		LoadUsers runner = new LoadUsers();
		runner.run(args);
	}

	// TODO
	void run(String... args) {
	try {
		System.out.println("Hooola");
		LeerFichero lf = new LeerFichero();
		lf.readXLSXFile();
	} catch (Exception e) {
		System.out.println("Excepcion..." + e);
	}	
	}
}
