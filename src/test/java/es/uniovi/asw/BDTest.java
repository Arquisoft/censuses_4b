package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.logica.Votante;
import es.uniovi.asw.persistencia.GestionBD;

public class BDTest {

	@Test
	public void test() {
		GestionBD g = new GestionBD();
		g.guardarVotanteDatosCompletos("Monica Cueva", "monicac@gmail.com", "12151651s", 306, "monicac", "dnjwenk");
		g.guardarVotanteDatosCompletos("Adrian Garcia", "adriang@gmail.com", "122651651s", 306, "adriang", "rtg");
		g.guardarVotanteDatosCompletos("Ana Bravo", "anab@gmail.com", "19861651s", 305, "anab", "fre");
		
		g.cargarDatosVotante();
		List<Votante> votantes = g.getVotantes();
		assertEquals("Monica Cueva", votantes.get(0).getNombre());
		assertEquals("Adrian Garcia", votantes.get(1).getNombre());
		assertEquals("Ana Bravo", votantes.get(2).getNombre());
		assertNotEquals("Ana Bravo", votantes.get(0).getNombre());
		
		assertEquals("monicac@gmail.com", votantes.get(0).getEmail());
		assertEquals("adriang@gmail.com", votantes.get(1).getEmail());
		assertEquals("anab@gmail.com", votantes.get(2).getEmail());
		g.cerrarConexion();
		
		g.crearConexion();
		assertEquals("dnjwenk", votantes.get(0).getClave());
		g.actualizarClave("monicac", "150ew");
		g.cargarDatosVotante();
		votantes = g.getVotantes();
		assertEquals("150ew", votantes.get(0).getClave());
		g.cerrarConexion();
		
		g.crearConexion();
		g.borrarVotante("12151651s");
		g.borrarVotante("122651651s");
		g.borrarVotante("19861651s");
		g.cerrarConexion();
		
		g.crearConexion();
		g.cargarDatosVotante();
		votantes = g.getVotantes();
		assertEquals(0, votantes.size());
		g.cerrarConexion();
	
	}

}
