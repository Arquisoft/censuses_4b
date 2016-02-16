package es.uniovi.asw.factoria;

import es.uniovi.asw.database.BDDao;
import es.uniovi.asw.database.impl.BDDaoImpl;
import es.uniovi.asw.parser.ReadCensus;
import es.uniovi.asw.parser.impl.LeerFichero;

public class ServicesFactory {
	public ServicesFactory(){
		
	}
	public static BDDao getBDDAO(){
		return new BDDaoImpl();
	}
	
	public static ReadCensus getReadCensus(){
		return new LeerFichero();
	}
}
