package es.uniovi.asw;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.logica.Votante;

/**
 * Clase para comprobar el funcionamiento del generador de cartas
 * @author Agl
 *
 */
public class GeneradorCartasTest {

	private Votante votante = new Votante("Lumbreras", "lumbreras@email.com", "123456789A", 10, 5);
	private Votante votante2 = new Votante("Monica", "monica@email.com", "125456789A", 12, 5);
	private Votante votante3 = new Votante("Ana", "ana@email.com", "145456789A", 12, 5);

	@Test
	public void crearCartas() {
				
		assertEquals("Lumbreras", votante.getNombre());
		assertEquals("Monica", votante2.getNombre());
		assertEquals("Ana", votante3.getNombre());
	}
	
}
