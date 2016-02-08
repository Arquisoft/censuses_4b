package main.java.es.uniovi.asw.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.es.uniovi.asw.logica.Votante;

/**
 * Clase que gestiona la base de datos de los censos
 * 
 * @author Mónica
 *
 */
public class GestionBD {

	private List<Votante> votantes = null; // Lista de votantes
	static Connection con;
	Statement st;
	ResultSet rs;

	/**
	 * Constructor sin parámetros de GestionBD Inicializa la lista de votantes,
	 * crea la conexión, carga los datos del votante y cierra la coneción.
	 */
	public GestionBD() {
		super();
		votantes = new ArrayList<Votante>();
		crearConexion();
		cargarDatosVotante();
		cerrarConexion();
	}

	/**
	 * Método que crea la conexión con la base de datos hsqldb.
	 */
	public void crearConexion() {
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost",
					"sa", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que almacena los datos del votante de la base de datos en la lista
	 * de votantes.
	 */
	public void cargarDatosVotante() {
		String consulta = "select  nombre, email, nif, cod_colegio, mesa, usuario,"
				+ " clave, ejercio_su_derecho_al_voto  from votante";

		try {
			st = con.createStatement();
			rs = st.executeQuery(consulta);

			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String nif = rs.getString("nif");
				int codigoColegio = rs.getInt("cod_colegio");
				int mesa = rs.getInt("mesa");
				String usuario = rs.getString("usuario");
				String clave = rs.getString("clave");
				boolean ejercioDerechoAlVoto = rs.getBoolean("ejercio_su_derecho_al_voto");

				Votante v = new Votante(nombre, email, nif, codigoColegio,
						mesa, usuario, clave, ejercioDerechoAlVoto);
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
	 * @param usuario del votante
	 * @param clave del votante
	 * @param nif Número de identificación fiscal del votante
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
	 * Método que almacena en la base de datos al votante del censo.
	 * Inicialmente, no hay ni usuario ni clave, y el votante no ha votado.
	 * @param nombre y apellidos del votante
	 * @param email del votante
	 * @param nif Número de identificación fiscal del votante
	 * @param codigoColegio Código del colegio electoral al que tiene que acudir el votante
	 * @param mesa Mesa del colegio electoral a la que tiene que acudir el votante
	 */
	public void guardarVotanteCenso(String nombre, String email, String nif, int codigoColegio, int mesa){
		
		String consulta = "insert into votante values ('"+ nombre +"','"+ email
				+ "','" + nif + "', "+ codigoColegio +",'" + "" 
				+ "','" + "" + "',false, "+ mesa +")";
		
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
	 * Método que cierra la conexión.
	 */
	private void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
