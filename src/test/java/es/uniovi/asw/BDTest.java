package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.database.impl.BDDaoImpl;
import es.uniovi.asw.logica.Votante;

public class BDTest {

	/**
	 * Test que comprueba el correcto funcionamiento de la base de datos.
	 */
	@Test
	public void test() {
		BDDaoImpl g = new BDDaoImpl();
		g.updateDB("Monica Cueva", "monicac@gmail.com", "12151651s", 306, "monicac", "dnjwenk");
		g.updateDB("Adrian Garcia", "adriang@gmail.com", "122651651s", 306, "adriang", "rtg");
		g.updateDB("Ana Bravo", "anab@gmail.com", "19861651s", 305, "anab", "fre");
		
		g.cargarDatosVotante();
		List<Votante> votantes = g.getVotantes();
		for (Votante votante : votantes) {
			if(votante.getNif().equals("12151651s")){
				assertEquals("Monica Cueva", votante.getNombre());
				assertEquals("monicac@gmail.com", votante.getEmail());
			}else if(votante.getNif().equals("122651651s")){
				assertEquals("Adrian Garcia", votante.getNombre());
				assertEquals("adriang@gmail.com", votante.getEmail());
			}else if(votante.getNif().equals("19861651s")){
				assertEquals("anab@gmail.com", votante.getEmail());
				assertEquals("Ana Bravo", votante.getNombre());
			}
		}
		g.cerrarConexion();
		
		g.crearConexion();
		g.updatePasswd("monicac", "150ew");
		g.cargarDatosVotante();
		votantes = g.getVotantes();
		for (Votante votante : votantes) {
			if(votante.getNif().equals("12151651s")){
				assertEquals("150ew", votante.getClave());
			}
		}	
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
