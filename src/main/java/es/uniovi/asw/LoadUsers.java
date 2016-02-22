package es.uniovi.asw;


import java.util.ArrayList;

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

	
	@Bean
	public CommandLineRunner demo(final VoterRepository repository) {
		return (args) -> {
			
			LeerFicheroXlsx leerxlsx = (LeerFicheroXlsx)ParserFactory.getParserXlsx(repository);
			leerxlsx.readCensus("test.xlsx"); //lee el fichero en formato .xlsx
			leerxlsx.insert();			
			
			log.info("--------------------------------------------");
			log.info("Información de los votantes: ");
			for (Voter voter : repository.findAll()) {
				log.info(voter.toString());
			}
			log.info("--------------------------------------------");
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
