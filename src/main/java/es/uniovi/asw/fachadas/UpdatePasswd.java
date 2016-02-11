package es.uniovi.asw.fachadas;

/**
 * Actualiza la clave del usuario en la base de datos.
 * @author Mónica
 *
 */
public interface UpdatePasswd {
	
	public void updatePasswdVotante(String usuario, String clave);

}
