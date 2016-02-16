package es.uniovi.asw.parser.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.database.impl.BDDaoImpl;
import es.uniovi.asw.factoria.PersistenceFactory;
import es.uniovi.asw.logica.Votante;
import es.uniovi.asw.parser.Parser;

/**
 * 
 * @author Ana
 *Clase que lee el fichero excel con los datos de los ciudadanos
 */
public class LeerFicheroXlsx  implements Parser{
	
	 ArrayList<Votante> votantes;
	 BDDaoImpl dbDao;
	
	
	public LeerFicheroXlsx() {
		votantes = new ArrayList<Votante>();
		dbDao = (BDDaoImpl) PersistenceFactory.getBDDAO();
	}
	
	
	
	/**
	 * Método que lee el fichero excel con los datos del censo
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public  void readCensus(String ruta) {
		
		InputStream ExcelFileToRead;
		XSSFWorkbook wb =null;
		try {
			ExcelFileToRead = new FileInputStream(ruta);
			try {
				wb = new XSSFWorkbook(ExcelFileToRead);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero.");
		}
	//	XSSFWorkbook test = new XSSFWorkbook(); //¿no se usa ana?

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		
	//	int k = 0; //¿no se usa ana?
		rows.next();
		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			ArrayList<Object> datos = new ArrayList<Object>();
			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();

				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
					datos.add(cell.getStringCellValue());
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
					datos.add(cell.getNumericCellValue());
				} else {
					System.out.println("No está especificado el tipo");
				}

			}
	
			
			votantes.add(new Votante(datos.get(0).toString(), datos.get(2).toString(), 
					datos.get(1).toString(), (int) Double.parseDouble(datos.get(3).toString())));
			
			
		}

	}

	/**
	 * Llama a un método del componente DBUpdate para hacer la inserción en la base de datos
	 */
	@Override
	public void insert(){
		
		dbDao.crearConexion();
		
		for (Votante votante : votantes) {
			dbDao.insert(votante);
		}
		
		dbDao.cerrarConexion();
	}
	
	/**
	 * Método que devuelve una colección de votantes.
	 * @return
	 */
	public  ArrayList<Votante> getVotantes(){
		return votantes;
	}




	
	
}
