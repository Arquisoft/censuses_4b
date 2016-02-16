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
import es.uniovi.asw.logica.Votante;
import es.uniovi.asw.parser.ReadCensus;

/**
 * 
 * @author Ana
 *Clase que lee el fichero excel con los datos de los ciudadanos
 */
public class LeerFichero implements ReadCensus{
	/**
	 * Método que lee el fichero excel
	 * @return Array de un array con los datos de los ciudadanos
	 */
	public ArrayList<Votante> readXLSXFile(String ruta) {
		InputStream ExcelFileToRead;
		XSSFWorkbook wb =null;
		try {
			ExcelFileToRead = new FileInputStream(ruta);
			try {
				wb = new XSSFWorkbook(ExcelFileToRead);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook test = new XSSFWorkbook();

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		ArrayList<Votante> array = new ArrayList<Votante>();

		int k = 0;
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
			array.add(new Votante(String.valueOf(datos.get(0)), String.valueOf(datos.get(2)), 
					String.valueOf(datos.get(1)),  Integer.parseInt(String.valueOf(datos.get(3)))));
		}
		return array;

	}

	/*public void guardarEnBD() {
		ArrayList<ArrayList<Object>> array = new ArrayList<ArrayList<Object>>();
		BDDaoImpl g = new BDDaoImpl();
		for (int i = 1; i < array.size(); i++)
			g.guardarVotanteCenso(String.valueOf(array.get(i).get(0)), String.valueOf(array.get(i).get(2)),
					String.valueOf(array.get(i).get(1)), Integer.parseInt(String.valueOf(array.get(i).get(3))));
	}*/
}
