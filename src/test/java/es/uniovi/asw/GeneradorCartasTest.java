package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.itextpdf.text.DocumentException;

import es.uniovi.asw.modelo.Voter;
import es.uniovi.asw.reportwriter.*;
import es.uniovi.asw.reportwriter.impl.CartasPDF;
import es.uniovi.asw.reportwriter.impl.CartasTXT;

/**
 * Clase para comprobar el funcionamiento del generador de cartas
 * @author Agl
 *
 */
public class GeneradorCartasTest {

	private Voter votante1 = new Voter("Lumbreras", "lumbreras@email.com", "1111111A", 10);
	private Voter votante2 = new Voter("Monica", "monica@email.com", "22222222B", 12);
	private Voter votante3 = new Voter("Ana", "ana@email.com", "33333333C", 15);

	@Test
	public void crearCartasTest() throws IOException, DocumentException {
				
		assertEquals("Lumbreras", votante1.getNombre());
		assertEquals("Monica", votante2.getNombre());
		assertEquals("Ana", votante3.getNombre());
		
		assertEquals("lumbreras@email.com", votante1.getEmail());
		assertEquals("monica@email.com", votante2.getEmail());
		assertEquals("ana@email.com", votante3.getEmail());
		
		assertEquals("1111111A", votante1.getNif());
		assertEquals("22222222B", votante2.getNif());
		assertEquals("33333333C", votante3.getNif());
		
		CartasTXT Lum = new CartasTXT(votante1);
		CartasTXT Monica = new CartasTXT(votante2);
		CartasTXT Ana = new CartasTXT(votante3);
		
		CartasPDF Lums = new CartasPDF(votante1);
		CartasPDF Monicas = new CartasPDF(votante2);
		CartasPDF Anas = new CartasPDF(votante3);
		
	}
	
}
