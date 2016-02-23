package es.uniovi.asw.dbupdate;

import java.util.List;

import es.uniovi.asw.modelo.Voter;

public interface BDDao {

	/**
	 * Método que crea la conexión con la base de datos h2.
	 */
	public void crearConexion();

	/**
	 * Método que recibe un objeto con la información para insertar en la base
	 * de datos.
	 * 
	 * @param votante
	 */
	public void insert(Voter votante);

	/**
	 * Método que devuelve los datos de un votante.
	 * 
	 * @param nif
	 *            número de identificación fiscal del votante.
	 * @return devuelve el votante con el nif pasado por parámetro.
	 */
	public Voter getVoter(String nif);

	/**
	 * Método que inserta en la base de datos los datos de un votante, incluida
	 * su contraseña.
	 * 
	 * @param nombre
	 *            y apellidos del votante
	 * @param email
	 *            del votante
	 * @param nif
	 *            Número de identificación fiscal del votante
	 * @param codigoColegio
	 *            Código del colegio electoral al que tiene que acudir el
	 *            votante
	 * @param usuario
	 *            del votante
	 * @param clave
	 *            del votante
	 */
	public void updateDB(String nombre, String email, String nif,
			int codigoColegio, String usuario, String clave);

	/**
	 * Método que actualiza en la base de datos la clave del votante.
	 * 
	 * @param usuario
	 *            del votante
	 * @param clave
	 *            del votante
	 */
	public void updatePasswd(String usuario, String clave);

	/**
	 * Método que almacena los datos del votante de la base de datos en la lista
	 * de votantes.
	 */
	public void cargarDatosVotante();

	/**
	 * Método que almacena en la base de datos el usuario y clave del votante.
	 * 
	 * @param usuario
	 *            del votante
	 * @param clave
	 *            del votante
	 * @param nif
	 *            Número de identificación fiscal del votante
	 */
	public void actualizarUsuarioYClave(String usuario, String clave, String nif);
	

	/**
	 * Método que devuelve la lista de todos los votantes del censo.
	 * 
	 * @return devuelve una lista d votantes
	 */
	public List<Voter> getVotantes();

	/**
	 * Método que elimina el votante según su nif.
	 * 
	 * @param nif
	 *            del votante
	 */
	public void borrarVotante(String nif);

	/**
	 * Método que cierra la conexión.
	 */
	public void cerrarConexion();
}
