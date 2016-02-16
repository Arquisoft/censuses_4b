package es.uniovi.asw.parser;

public interface Parser {
	
	
	/**
	 * Método que lee el fichero excel con los datos del censo
	 */
	public void readCensus(String ruta);
	
	/**
	 * Llama a un método del componente DBUpdate para hacer la inserción en la base de datos
	 */
	public void insert();
		

}
