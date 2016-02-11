package es.uniovi.asw.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.logica.Votante;

/**
 * Clase que gestiona la base de datos de los censos
 * 
 * @author M�nica
 *
 */
public class GestionBD {

	private List<Votante> votantes = null; // Lista de votantes
	static Connection con;
	Statement st;
	ResultSet rs;

	/**
	 * Constructor sin par�metros de GestionBD Inicializa la lista de votantes,
	 * crea la conexi�n, carga los datos del votante y cierra la coneci�n.
	 */
	public GestionBD() {
		super();
		votantes = new ArrayList<Votante>();
		crearConexion();
		//cargarDatosVotante();
		//cerrarConexion();
	}

	/**
	 * M�todo que crea la conexi�n con la base de datos hsqldb.
	 */
	public void crearConexion() {
		
		try{
			Class.forName("org.hsqldb.jdbcDriver");
		}catch(ClassNotFoundException e){
			throw new RuntimeException("No se ha encontrado el driver", e);
		}
		
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost", "sa", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * M�todo que almacena los datos del votante de la base de datos en la lista
	 * de votantes.
	 */
	public void cargarDatosVotante() {
		
		votantes = new ArrayList<Votante>();
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
				boolean ejercioDerechoAlVoto = rs.getBoolean("ejercio_su_derecho_al_voto");

				Votante v = new Votante(nombre, email, nif, codigoColegio,
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
	 * M�todo que almacena en la base de datos el usuario y clave del votante.
	 * @param usuario del votante
	 * @param clave del votante
	 * @param nif N�mero de identificaci�n fiscal del votante
	 */
	public void guardarUsuarioYClave(String usuario, String clave, String nif){
		
		String consulta = "update votante set usuario='" + usuario
				+ "' , clave='" + clave +"' where nif='" + nif + "' ";
		
		try{
			st = con.createStatement();
			rs = st.executeQuery(consulta);
			rs.close();
			st.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que actualiza en la base de datos la clave del votante.
	 * @param usuario del votante
	 * @param clave del votante
	 */
	public void actualizarClave(String usuario, String clave){
		
		String consulta = "update votante set clave='" + clave 
				+"' where usuario='" + usuario + "' ";
		
		try{
			st = con.createStatement();
			rs = st.executeQuery(consulta);
			rs.close();
			st.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	

	/**
	 * M�todo que almacena en la base de datos al votante del censo.
	 * Inicialmente, no hay ni usuario ni clave, y el votante no ha votado.
	 * @param nombre y apellidos del votante
	 * @param email del votante
	 * @param nif N�mero de identificaci�n fiscal del votante
	 * @param codigoColegio C�digo del colegio electoral al que tiene que acudir el votante
	 * @param mesa Mesa del colegio electoral a la que tiene que acudir el votante
	 */
	public void guardarVotanteCenso(String nombre, String email, String nif, int codigoColegio){
		
		String consulta = "insert into votante values ('"+ nombre +"','"+ email
				+ "','" + nif + "', "+ codigoColegio +",'" + "" 
				+ "','" + "" + "',false)";
		
		try{
			st = con.createStatement();
			rs = st.executeQuery(consulta);
			rs.close();
			st.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que almacena en la base de datos al votante del censo, con usuario y contraseña.
	 * @param nombre y apellidos del votante
	 * @param email del votante
	 * @param nif Número de identificaci�n fiscal del votante
	 * @param codigoColegio Código del colegio electoral al que tiene que acudir el votante
	 * @param usuario del votante
	 * @param clave del votante
	 */
	public void guardarVotanteDatosCompletos(String nombre, String email, String nif, int codigoColegio, String usuario, String clave){
		
		String consulta = "insert into votante values ('"+ nombre +"','"+ email
				+ "','" + nif + "', "+ codigoColegio +",'" + usuario 
				+ "','" + clave + "',false)";
		
		try{
			st = con.createStatement();
			rs = st.executeQuery(consulta);
			rs.close();
			st.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que devuelve la lista de todos los votantes del censo.
	 * @return devuelve una lista d votantes
	 */
	public List<Votante> getVotantes(){
		return votantes;
	}
	
	/**
	 * Método que elimina el votante según su nif.
	 * @param nif del votante
	 */
	public void borrarVotante(String nif){
		String consulta = "DELETE FROM VOTANTE where nif='" + nif + "'";
		try{
			st = con.createStatement();
			rs = st.executeQuery(consulta);
			rs.close();
			st.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * M�todo que cierra la conexi�n.
	 */
	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
