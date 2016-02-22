package es.uniovi.asw.database;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.logica.Voter;

public interface VoterRepository extends CrudRepository<Voter, Long>{
	
	/**
	 * Método que devuelve un votante que tenga el nif pasado por parámetro.
	 * @param nif
	 * @return
	 */
	Voter findByNif(String nif);
	
	/**
	 * Método que devuelve una lista de los votantes
	 * que hay en la base de datos.
	 */
	List<Voter> findAll();


}
