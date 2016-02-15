package es.uniovi.asw.parser;

import java.util.ArrayList;

import es.uniovi.asw.logica.Votante;

public interface ReadCensus {
	
	public ArrayList<ArrayList<Object>> readXLSXFile(String ruta);

}
