package es.uniovi.asw.fachadas;

import es.uniovi.asw.logica.Votante;


/**
 * Devuelve los datos de un votante.
 * @author Mónica
 *
 */
public interface GetVoter {
	
	/**
	 * Devuelve un votante.
	 * @return
	 */
	public Votante getVotante(String nif);

}
