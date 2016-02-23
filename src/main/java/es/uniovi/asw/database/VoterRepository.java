package es.uniovi.asw.database;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

	@Modifying
	@Query("update Voter v set v.usuario = ?1 where v.nif = ?2")
	void setUsuarioFor(String usuario, String nif);

	@Modifying
	@Query("update Voter v set v.clave = ?1 where v.nif = ?2")
	void setClaveFor(String clave, String nif);
}
