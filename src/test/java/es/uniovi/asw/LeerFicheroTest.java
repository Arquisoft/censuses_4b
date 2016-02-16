package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import es.uniovi.asw.database.impl.BDDaoImpl;
import es.uniovi.asw.factoria.ParserFactory;
import es.uniovi.asw.factoria.PersistenceFactory;
import es.uniovi.asw.logica.Votante;
import es.uniovi.asw.parser.impl.LeerFicheroXlsx;

public class LeerFicheroTest {

	@Test
	public void testLeerFichero() throws IOException {
		LeerFicheroXlsx lf = new LeerFicheroXlsx();
		ArrayList<Votante> votantes = new ArrayList<Votante>();
		Votante v1 = new Votante("Juan Torres Pardo", "juan@correo.es", "90500084Y", 234);
		Votante v2 = new Votante("Luis López Fernando", "Luis@correo.es", "19160962F", 345);
		Votante v3 = new Votante("Ana Torres Pardo", "Ana@correo.es", "09940449X", 456);
		votantes.add(v1);
		votantes.add(v2);
		votantes.add(v3);

		lf.readCensus("test.xlsx");
		assertEquals(lf.getVotantes().toString(), votantes.toString());
		
	}

	@Test
	public void testGuardarDatosBDD() {
		
		LeerFicheroXlsx lf = (LeerFicheroXlsx)ParserFactory.getParserXlsx();
		
		ArrayList<Votante> votantes = new ArrayList<Votante>();
		Votante v1 = new Votante("Juan Torres Pardo", "juan@correo.es", "90500084Y", 234);
		Votante v2 = new Votante("Luis López Fernando", "Luis@correo.es", "19160962F", 345);
		Votante v3 = new Votante("Ana Torres Pardo", "Ana@correo.es", "09940449X", 456);
		votantes.add(v1);
		votantes.add(v2);
		votantes.add(v3);

		lf.readCensus("test.xlsx");
		lf.insert();
		
		BDDaoImpl bd = (BDDaoImpl) PersistenceFactory.getBDDAO();
		bd.crearConexion();
		bd.cargarDatosVotante();		

		bd.borrarVotante("90500084Y");
		bd.borrarVotante("19160962F");
		bd.borrarVotante("09940449X");
		bd.crearConexion();
		

	}
}
