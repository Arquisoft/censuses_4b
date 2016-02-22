package es.uniovi.asw.persistencia;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import es.uniovi.asw.logica.Voter;

public interface GeneradorCartas {
	
	public void generador(Voter votante) throws IOException, DocumentException;
}
