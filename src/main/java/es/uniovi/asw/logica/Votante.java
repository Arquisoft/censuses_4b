package es.uniovi.asw.logica;



/**
 * Clase Votante
 * @author Mónica
 *
 */
public class Votante {

	private String nombre; //Nombre y apellidos del votante
	private String email; //Correo electrónico del votante
	private String nif; //Número de identificación fiscal del votante
	private int codigoColegio; //Código del colegio electoral al que tiene que acudir el votante
	private String usuario; //Nombre de usuario del votante para acceder al sistema
	private String clave; //Clave del votante para acceder al sistema
	private boolean ejercioDerechoAlVoto; //Atributo booleano que indica si el usuario ha votado o no
	
	

	/**
	 * Constructor con todos los par�metros de la clase Votante.
	 * @param nombre y apellidos del votante
	 * @param email Correo electr�nico del votante
	 * @param nif N�mero de identificaci�n fiscal del votante
	 * @param email Correo electrónico del votante
	 * @param nif N�mero de identificación fiscal del votante
	 * @param codigoColegio C�digo del colegio electoral al que tiene que acudir el votante
	 * @param mesa Mesa del colegio electoral a la que tiene que acudir el votante
	 * @param usuario Nombre de usuario del votante para acceder al sistema
	 * @param clave Clave del votante para acceder al sistema
	 * @param ejercioDerechoAlVoto indica si el usuario ha votado o no	
	 * 
	 */
	public Votante(String nombre, String email, String nif, int codigoColegio, String usuario,
			String clave, boolean ejercioDerechoAlVoto) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.nif = nif;
		this.codigoColegio = codigoColegio;
		this.usuario = usuario;
		this.clave = clave;
		this.ejercioDerechoAlVoto = ejercioDerechoAlVoto;
	}
	
	
	
	/**
	 * Constructor con par�metros de la clase Votante sin generar usuario y clave.
	 * @param nombre y apellidos del votante
	 * @param email Correo electr�nico del votante
	 * @param nif N�mero de identificaci�n fiscal del votante
	 * @param codigoColegio C�digo del colegio electoral al que tiene que acudir el votante
	 * @param mesa Mesa del colegio electoral a la que tiene que acudir el votante
	 * 
	 */
	public Votante(String nombre, String email, String nif, int codigoColegio) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.nif = nif;
		this.codigoColegio = codigoColegio;
		this.usuario = ""; //a�n no se ha generado el usuario 
		this.clave = ""; //a�n no se ha generado el usuario
		this.ejercioDerechoAlVoto = false; //el votante a�n no ha votado
	}
	
	

	/**
	 * M�todo que modifica el valor del atributo nombre.
	 * @param nombre del votante
	 */
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	/**
	 * M�todo que obtiene el valor del atributo nombre.
	 * @return nombre del votante
	 */
	public String getNombre(){
		return nombre;
	}
	
	
	/**
	 * M�todo que modifica el valor del atributo email.
	 * @param email del votante
	 */
	public void setEmail(String email){
		this.email=email;
	}
	
	/**
	 * M�todo que obtiene el valor del atributo email.
	 * @return email del votante
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * M�todo que modifica el valor del atributo NIF.
	 * @param nif del votante
	 */
	public void setNif(String nif){
		this.nif=nif;
	}
	
	
	/**
	 * M�todo que obtiene el valor del atributo NIF.
	 * @return NIF del votante
	 */
	public String getNif(){
		return nif;
	}
	
	/**
	 * M�todo que modifica el valor del atributo codigoColegio.
	 * @param cod codigo del colegio al que tiene que ir el votante
	 */
	public void setCodigoColegio(int cod){
		this.codigoColegio=cod;
	}
	
	
	/**
	 * M�todo que obtiene el valor del atributo codigoColegio.
	 * @return codigo del colegio al que tiene que ir el votante
	 */
	public int getCodigoColegio(){
		return codigoColegio;
	}
	
	
	/**
	 * Metodo que modifica el valor del atributo usuario.
	 * @param usuario del votante para acceder al sistema
	 */
	public void setUsuario(String usuario){
		this.usuario=usuario;
	}
	
	/**
	 * Metodo que obtiene el valor del atributo usuario.
	 * @return usuario del votante para acceder al sistema
	 */
	public String getUsuario(){
		return usuario;
	}
	
	/**
	 * M�todo que modifica el valor del atributo clave.
	 * @param clave del votante para acceder al sistema
	 */
	public void setClave(String clave){
		this.clave=clave;
	}
	
	/**
	 * M�todo que obtiene el valor del atributo clave.
	 * @return clave del votante para acceder al sistema
	 */
	public String getClave(){
		return clave;
	}

	/**
	 * M�todo que obtiene el valor del atributo ejercioDerechoAlVoto.
	 * @return ejercioDerechoAlVoto devuelve true si el votante ha votado, false en caso contrario
	 */
	public boolean isEjercioDerechoAlVoto() {
		return ejercioDerechoAlVoto;
	}

	
	/**
	 * M�todo que modifica el valor del atributo ejercioDerechoAlVoto.
	 * @param ejercioDerechoAlVoto indica si el votante ha votado o no
	 */
	public void setEjercioDerechoAlVoto(boolean ejercioDerechoAlVoto) {
		this.ejercioDerechoAlVoto = ejercioDerechoAlVoto;
	}

	/**
	 * M�todo toString que muestra la informaci�n del votante.
	 */
	@Override
	public String toString() {
		return "Votante [nombre=" + nombre + ", email=" + email + ", NIF="
				+ nif + ", codigoColegio=" + codigoColegio 
				+ ", usuario=" + usuario + ", clave=" + clave
				+ ", ejercioDerechoAlVoto=" + ejercioDerechoAlVoto + "]";
	}
	
	
	
	
	
	
}
