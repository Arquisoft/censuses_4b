package es.uniovi.asw.factoria;

import es.uniovi.asw.database.BDDao;
import es.uniovi.asw.database.impl.BDDaoImpl;

public class ServicesFactory {
	public ServicesFactory(){
		
	}
	public static BDDao getBDDAO(){
		return new BDDaoImpl();
	}
}
