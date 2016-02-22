package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.uniovi.asw.database.VoterRepository;
import es.uniovi.asw.factoria.ParserFactory;
import es.uniovi.asw.logica.Voter;
import es.uniovi.asw.parser.impl.LeerFicheroXlsx;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LoadUsers.class)
public class LeerFicheroTest {

	@Autowired
	VoterRepository vr;
	List<Voter> votantes = new ArrayList<Voter>();
	
	@Before
	public void setUp() throws Exception {
		votantes = vr.findAll(); //Almaceno la base de datos generada de LoadUsers.class
		vr.deleteAll(); //borro toda la base de datos creada al ejecutar LoadUsers.class que inicializa VoterRepository.
	}
	
	@Test
	public void testLeerFichero() throws IOException {
		LeerFicheroXlsx lf = new LeerFicheroXlsx();
		ArrayList<Voter> votantes = new ArrayList<Voter>();
		Voter v1 = new Voter("Juan Torres Pardo", "juan@correo.es", "90500084Y", 234);
		Voter v2 = new Voter("Luis López Fernando", "Luis@correo.es", "19160962F", 345);
		Voter v3 = new Voter("Ana Torres Pardo", "Ana@correo.es", "09940449X", 456);
		votantes.add(v1);
		votantes.add(v2);
		votantes.add(v3);

		lf.readCensus("test.xlsx");
		assertEquals(lf.getVotantes().toString(), votantes.toString());
		
	}

	@Test
	public void testGuardarDatosBDD() {
		
		LeerFicheroXlsx lf = (LeerFicheroXlsx)ParserFactory.getParserXlsx(vr);
		
		List<Voter> votantes = new ArrayList<Voter>();
		Voter v1 = new Voter("Juan Torres Pardo", "juan@correo.es", "90500084Y", 234, "", "", false);
		Voter v2 = new Voter("Luis López Fernando", "Luis@correo.es", "19160962F", 345, "", "", false);
		Voter v3 = new Voter("Ana Torres Pardo", "Ana@correo.es", "09940449X", 456, "", "", false);
		votantes.add(v1);
		votantes.add(v2);
		votantes.add(v3);
		
		
		lf.readCensus("test.xlsx");
		lf.insert();
	
		assertEquals(votantes.toString(), vr.findAll().toString());
		

	}
	
	/**
	 * Método que vuelve almacenar los datos que 
	 * había en la bd al cargar LoadUsers.class
	 */
	@After
	public void testAñadirVotantesEliminados(){
		
		vr.deleteAll(); //borro los datos creados en el test
		assertEquals(0, vr.count());
		
		
		for (Voter voter : votantes) {
			vr.save(voter); //inserto los datos creados en LoadUsers.class
		}
		
		assertEquals(votantes.toString(), vr.findAll().toString());
		
		/*assertEquals("Monica Cueva", vr.findByNif("12151651s").getNombre());
		assertEquals("monicac@gmail.com", vr.findByNif("12151651s").getEmail());
		assertFalse(vr.findByNif("12151651s").isEjercioDerechoAlVoto());
		assertEquals(1, vr.count());*/
	}
}
