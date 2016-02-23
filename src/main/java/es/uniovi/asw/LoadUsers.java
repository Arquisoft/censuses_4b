package es.uniovi.asw;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.uniovi.asw.database.VoterRepository;
import es.uniovi.asw.factoria.ParserFactory;
import es.uniovi.asw.logica.Voter;
import es.uniovi.asw.parser.impl.LeerFicheroXlsx;
import es.uniovi.asw.persistencia.Generador;
import es.uniovi.asw.persistencia.GeneradorCartas;

/**
 * Main application
 * 
 * @author Labra
 *
 */

@SpringBootApplication
public class LoadUsers {
	

	/*public static void main(String... args) {
		LoadUsers runner = new LoadUsers();
		runner.run(args);
	}*/
	private static final Logger log = LoggerFactory.getLogger(LoadUsers.class);

	public static void main(String[] args) {
		SpringApplication.run(LoadUsers.class);
	}

	
	@SuppressWarnings("deprecation")
	@Bean
	public CommandLineRunner demo(final VoterRepository repository) {
		return (args) -> {
			
			CommandLineParser cmdlParser = null;
			CommandLine cmd = null;
			String ruta ="";
			LeerFicheroXlsx leerxlsx = (LeerFicheroXlsx)ParserFactory.getParserXlsx(repository);
			List<Voter> votantes = new ArrayList<Voter>();
					
			Options opciones = new Options();
			opciones.addOption("l", true, "Para leer el fichero xlsx, introduzca su ruta");
			opciones.addOption("t", "Generar carta en formato .txt");
			opciones.addOption("p", "Generar carta en formato.pdf");
			
			try {
				
				cmdlParser = new BasicParser();
				cmd = cmdlParser.parse(opciones, args);
				
				if(cmd.hasOption("l")){
					
					ruta = cmd.getOptionValue("l");
	
					leerxlsx.readCensus(ruta); //lee el fichero en formato .xlsx
					leerxlsx.insert();	//inserto los datos del fichero en la base de datos.	
					votantes = leerxlsx.getVotantes();
					System.out.println("Se ha leído el fichero excel correctamente.");
					
				}else if(cmd.hasOption("t")){
					
					for (Voter voter : votantes) {
						Generador g = new Generador(voter);
						//g.generarCarta(voter);
					}
					
					
				}else if(cmd.hasOption("p")){
					
					for (Voter voter : votantes) {
						Generador g = new Generador(voter);
						
					}
				}
				
				/*LeerFicheroXlsx leerxlsx = (LeerFicheroXlsx)ParserFactory.getParserXlsx(repository);
				leerxlsx.readCensus("test.xlsx"); //lee el fichero en formato .xlsx
				leerxlsx.insert();			
				
				log.info("--------------------------------------------");
				log.info("Información de los votantes: ");
				for (Voter voter : repository.findAll()) {
					log.info(voter.toString());
				}
				log.info("--------------------------------------------");*/
				
			} catch (Exception e) {
				System.out.println("Excepcion..." + e);
			}
		};
		
	}
	
	
	/*void run(String... args) {
	try {
		
		System.out.println("Hooola");
		
		LeerFicheroXlsx leerxlsx = (LeerFicheroXlsx)ParserFactory.getParserXlsx();
		leerxlsx.readCensus("test.xlsx"); //lee el fichero en formato .xlsx
		ArrayList<Voter> votantes = leerxlsx.getVotantes();
		for (Voter voter : votantes) {
			VoterRepository.save(voter);
		}
		leerxlsx.insert(); //inserta los datos del excel en la base de datos
		
	} catch (Exception e) {
		System.out.println("Excepcion..." + e);
	}	
	}*/
}
