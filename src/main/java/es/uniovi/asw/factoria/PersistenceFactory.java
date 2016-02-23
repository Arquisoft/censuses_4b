package es.uniovi.asw.factoria;

import es.uniovi.asw.dbupdate.BDDao;
import es.uniovi.asw.dbupdate.impl.BDDaoImpl;


public class PersistenceFactory {
	public PersistenceFactory(){
		
	}
	public static BDDao getBDDAO(){
		return new BDDaoImpl();
	}

}
