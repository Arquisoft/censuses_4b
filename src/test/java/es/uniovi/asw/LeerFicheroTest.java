package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import es.uniovi.asw.logica.Votante;
import es.uniovi.asw.parser.LeerFichero;
import es.uniovi.asw.persistencia.GestionBD;

public class LeerFicheroTest {

	@Test
	public void testLeerFichero() {
		LeerFichero lf = new LeerFichero();
		ArrayList<Object> a1 = new ArrayList<Object>();
		a1.add("Juan Torres Pardo");
		a1.add("90500084Y");
		a1.add("juan@correo.es");
		a1.add(234.0);
		ArrayList<Object> a2 = new ArrayList<Object>();
		a2.add("Luis López Fernando");
		a2.add("19160962F");
		a2.add("Luis@correo.es");
		a2.add(345.0);
		ArrayList<Object> a3 = new ArrayList<Object>();
		a3.add("Ana Torres Pardo");
		a3.add("09940449X");
		a3.add("Ana@correo.es");
		a3.add(456.0);
		ArrayList<ArrayList<Object>> array = new ArrayList<ArrayList<Object>>();
		array.add(a1);
		array.add(a2);
		array.add(a3);

		try {
			assertEquals(lf.readXLSXFile(), array);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGuardarDatosBDD() {
		GestionBD g = new GestionBD();
		LeerFichero lf = new LeerFichero();
		ArrayList<Object> a1 = new ArrayList<Object>();
		a1.add("Juan Torres Pardo");
		a1.add("90500084Y");
		a1.add("juan@correo.es");
		a1.add(234.0);
		ArrayList<Object> a2 = new ArrayList<Object>();
		a2.add("Luis López Fernando");
		a2.add("19160962F");
		a2.add("Luis@correo.es");
		a2.add(345.0);
		ArrayList<Object> a3 = new ArrayList<Object>();
		a3.add("Ana Torres Pardo");
		a3.add("09940449X");
		a3.add("Ana@correo.es");
		a3.add(456.0);
		ArrayList<ArrayList<Object>> array = new ArrayList<ArrayList<Object>>();
		array.add(a1);
		array.add(a2);
		array.add(a3);

		g.cargarDatosVotante();
		List<Votante> votantes = g.getVotantes();
		assertEquals("Juan Torres Pardo", votantes.get(0).getNombre());
		assertEquals("Luis López Fernando", votantes.get(2).getNombre());
		assertNotEquals("Ana Torres Pardo", votantes.get(0).getNombre());

		assertEquals("juan@correo.es", votantes.get(0).getEmail());
		assertEquals("Luis@correo.es", votantes.get(1).getEmail());
		assertEquals("Ana@correo.es", votantes.get(2).getEmail());
		g.cerrarConexion();

		g.crearConexion();
		g.borrarVotante("90500084Y");
		g.borrarVotante("19160962F");
		g.borrarVotante("09940449X");
		g.cerrarConexion();
	}
}
