package es.uniovi.asw.fachadas;

/**
 * Inserta en la base de datos los datos de un votante, incluida su contraseña.
 * @author Mónica
 *
 */
public interface UpdateBD {
	
	public void updateVotante(String nombre, String email, String nif, int codigoColegio, String usuario, String clave);

}
