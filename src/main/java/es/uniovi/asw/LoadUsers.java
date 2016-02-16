package es.uniovi.asw;


import es.uniovi.asw.factoria.ParserFactory;
import es.uniovi.asw.parser.impl.LeerFicheroXlsx;

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


	void run(String... args) {
	try {
		
		System.out.println("Hooola");
		
		LeerFicheroXlsx leerxlsx = (LeerFicheroXlsx)ParserFactory.getParserXlsx();
		leerxlsx.readCensus("test.xlsx"); //lee el fichero en formato .xlsx
		leerxlsx.insert(); //inserta los datos del excel en la base de datos
		
	} catch (Exception e) {
		System.out.println("Excepcion..." + e);
	}	
	}
}
