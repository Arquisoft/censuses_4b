package es.uniovi.asw.factoria;

import es.uniovi.asw.dbupdate.VoterRepository;
import es.uniovi.asw.parser.ReadCensus;
import es.uniovi.asw.parser.impl.LeerFicheroXlsx;

public class ParserFactory {

	public ParserFactory(){
		
	}
	public static ReadCensus getReadCensusXlsx(VoterRepository repository){
		return new LeerFicheroXlsx(repository);
	}

}
