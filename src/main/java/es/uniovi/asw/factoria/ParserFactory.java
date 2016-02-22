package es.uniovi.asw.factoria;

import es.uniovi.asw.database.VoterRepository;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.impl.LeerFicheroXlsx;

public class ParserFactory {
public ParserFactory(){
		
	}
	public static Parser getParserXlsx(VoterRepository repository){
		return new LeerFicheroXlsx(repository);
	}

}
