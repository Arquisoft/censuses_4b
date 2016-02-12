package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import es.uniovi.asw.logica.Votante;
import es.uniovi.asw.persistencia.*;

/**
 * Clase para comprobar el funcionamiento del generador de cartas
 * @author Agl
 *
 */
public class GeneradorCartasTest {

	private Votante votante1 = new Votante("Lumbreras", "lumbreras@email.com", "1111111A", 10);
	private Votante votante2 = new Votante("Monica", "monica@email.com", "22222222B", 12);
	private Votante votante3 = new Votante("Ana", "ana@email.com", "33333333C", 15);

	@Test
	public void crearCartasTest() throws IOException {
				
		assertEquals("Lumbreras", votante1.getNombre());
		assertEquals("Monica", votante2.getNombre());
		assertEquals("Ana", votante3.getNombre());
		
		assertEquals("lumbreras@email.com", votante1.getEmail());
		assertEquals("monica@email.com", votante2.getEmail());
		assertEquals("ana@email.com", votante3.getEmail());
		
		assertEquals("1111111A", votante1.getNif());
		assertEquals("22222222B", votante2.getNif());
		assertEquals("33333333C", votante3.getNif());
		
		Generador Lum = new Generador(votante1);
		Generador Monica = new Generador(votante2);
		Generador Ana = new Generador(votante3);
		
	}
	
}
