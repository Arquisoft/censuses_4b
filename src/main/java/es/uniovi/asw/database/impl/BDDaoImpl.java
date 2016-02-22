package es.uniovi.asw.database.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.database.BDDao;
import es.uniovi.asw.logica.Voter;

/**
 * Clase que gestiona la base de datos de los censos
 * 
 * @author Mónica
 *
 */
public class BDDaoImpl implements BDDao {

	private List<Voter> votantes = null; // Lista de votantes
	static Connection con;
	Statement st;
	ResultSet rs;

	/**
	 * Constructor sin parámetros de GestionBD Inicializa la lista de votantes,
	 * crea la conexión, carga los datos del votante y cierra la coneción.
	 */
	public BDDaoImpl() {
		super();
		votantes = new ArrayList<Voter>();
		crearConexion();
		// cargarDatosVotante();
		// cerrarConexion();
	}

	/**
	 * Método que crea la conexión con la base de datos h2.
	 */
	@Override
	public void crearConexion() {

		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver", e);
		}

		try {
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test",
					"sa", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que recibe un objeto con la información para insertar en la base
	 * de datos.
	 * @param Voter objeto votante con la información del mismo.
	 */
	@Override
	public void insert(Voter votante) {
		
		String consulta = "insert into votante values ('" + votante.getNombre() + "','"
				+ votante.getEmail() + "','" + votante.getNif() + "', " + votante.getCodigoColegio() + ",'" + votante.getUsuario()
				+ "','" + votante.getClave() + "', '" + votante.isEjercioDerechoAlVoto() + "')";

		try {
			st = con.createStatement();
			st.executeUpdate(consulta);
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Método que devuelve los datos de un votante.
	 * 
	 * @param nif
	 *            número de identificación fiscal del votante.
	 * @return devuelve el votante con el nif pasado por parámetro.
	 */
	@Override
	public Voter getVoter(String nif) {
		for (Voter votante : votantes) {
			if (votante.getNif().equals(nif)) {
				return votante;
			}
		}
		return null;
	}

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
	@Override
	public void updateDB(String nombre, String email, String nif,
			int codigoColegio, String usuario, String clave) {

		String consulta = "insert into votante values ('" + nombre + "','"
				+ email + "','" + nif + "', " + codigoColegio + ",'" + usuario
				+ "','" + clave + "',false)";

		try {
			st = con.createStatement();
			st.executeUpdate(consulta);
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que actualiza en la base de datos la clave del votante.
	 * 
	 * @param usuario
	 *            del votante
	 * @param clave
	 *            del votante
	 */
	@Override
	public void updatePasswd(String usuario, String clave) {

		String consulta = "update votante set clave='" + clave
				+ "' where usuario='" + usuario + "' ";

		try {
			st = con.createStatement();
			st.executeUpdate(consulta);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que almacena los datos del votante de la base de datos en la lista
	 * de votantes.
	 */
	@Override
	public void cargarDatosVotante() {

		votantes = new ArrayList<Voter>();
		String consulta = "select  nombre, email, nif, cod_colegio,usuario,"
				+ " clave, ejercio_su_derecho_al_voto  from votante";

		try {
			st = con.createStatement();
			rs = st.executeQuery(consulta);

			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String nif = rs.getString("nif");
				int codigoColegio = rs.getInt("cod_colegio");
				String usuario = rs.getString("usuario");
				String clave = rs.getString("clave");
				boolean ejercioDerechoAlVoto = rs
						.getBoolean("ejercio_su_derecho_al_voto");

				Voter v = new Voter(nombre, email, nif, codigoColegio,
						usuario, clave, ejercioDerechoAlVoto);
				votantes.add(v);
			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

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
	@Override
	public void actualizarUsuarioYClave(String usuario, String clave, String nif) {

		String consulta = "update votante set usuario='" + usuario
				+ "' , clave='" + clave + "' where nif='" + nif + "' ";

		try {
			st = con.createStatement();
			st.executeUpdate(consulta);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que devuelve la lista de todos los votantes del censo.
	 * 
	 * @return devuelve una lista d votantes
	 */
	@Override
	public List<Voter> getVotantes() {
		return votantes;
	}

	/**
	 * Método que elimina el votante según su nif.
	 * 
	 * @param nif
	 *            del votante
	 */
	@Override
	public void borrarVotante(String nif) {
		String consulta = "DELETE FROM VOTANTE where nif='" + nif + "'";
		try {
			st = con.createStatement();
			st.executeUpdate(consulta);
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que cierra la conexión.
	 */
	@Override
	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
