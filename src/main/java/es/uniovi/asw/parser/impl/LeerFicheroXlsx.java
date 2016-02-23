package es.uniovi.asw.parser.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.database.VoterRepository;
import es.uniovi.asw.database.impl.BDDaoImpl;
import es.uniovi.asw.factoria.PersistenceFactory;
import es.uniovi.asw.logica.Voter;
import es.uniovi.asw.parser.Parser;

/**
 * 
 * @author Ana
 *Clase que lee el fichero excel con los datos de los ciudadanos
 */
public class LeerFicheroXlsx  implements Parser{
	
	 List<Voter> votantes;
	// BDDaoImpl dbDao;
	 VoterRepository repository = null;
	

	public LeerFicheroXlsx(VoterRepository repository) {
		votantes = new ArrayList<Voter>();
		this.repository = repository;
		//dbDao = (BDDaoImpl) PersistenceFactory.getBDDAO();
	}
	
	public LeerFicheroXlsx(){
		votantes = new ArrayList<Voter>();
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

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		
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
	
			
			votantes.add(new Voter(datos.get(0).toString(), datos.get(2).toString(),
					datos.get(1).toString(),(int) Double.parseDouble(datos.get(3).toString()),
					"", "", false));
			
			
			
		}

	}

	/**
	 * Llama a un método del componente DBUpdate para hacer la inserción en la base de datos
	 */
	@Override
	public void insert(){
		
	//	dbDao.crearConexion();
		
		for (Voter votante : votantes) {
			if(repository.findByNif(votante.getNif())==null){ //si el votante no está ya en la base de datos
				repository.save(votante);
			}
			//dbDao.insert(votante);
		}
		
	//	dbDao.cerrarConexion();
	}
	
	/**
	 * Método que devuelve una colección de votantes.
	 * @return
	 */
	public  List<Voter> getVotantes(){
		return votantes;
	}




	
	
}
