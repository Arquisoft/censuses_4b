

/**
 * Clase Votante
 * @author M�nica
 *
 */
public class Votante {

	public String nombre; //Nombre y apellidos del votante
	public String email; //Correo electr�nico del votante
	public String NIF; //N�mero de identificaci�n fiscal del votante
	public int codigoColegio; //C�digo del colegio electoral al que tiene que acudir el votante
	public int mesa; //Mesa del colegio electoral a la que tiene que acudir el votante
	public String usuario; //Nombre de usuario del votante para acceder al sistema
	public String clave; //Clave del votante para acceder al sistema
	public boolean ejercioDerechoAlVoto; //Atributo booleano que indica si el usuario ha votado o no
	
	
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
	public void setNIF(String nif){
		this.NIF=nif;
	}
	
	
	/**
	 * M�todo que obtiene el valor del atributo NIF.
	 * @return NIF del votante
	 */
	public String getNIF(){
		return NIF;
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
	 * M�todo que modifica el valor del atributo mesa.
	 * @param mesa a la que tiene que ir el votante
	 */
	public void setMesa(int mesa){
		this.mesa=mesa;
	}
	
	/**
	 * M�todo que obtiene el valor del atributo mesa.
	 * @return mesa a la que tiene que el votante
	 */
	public int getMesa(){
		return mesa;
	}
	
	/**
	 * M�todo que modifica el valor del atributo usuario.
	 * @param usuario del votante para acceder al sistema
	 */
	public void setUsuario(String usuario){
		this.usuario=usuario;
	}
	
	/**
	 * M�todo que obtiene el valor del atributo usuario.
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
				+ NIF + ", codigoColegio=" + codigoColegio + ", mesa=" + mesa
				+ ", usuario=" + usuario + ", clave=" + clave
				+ ", ejercioDerechoAlVoto=" + ejercioDerechoAlVoto + "]";
	}
	
	
	
	
	
	
}
