package es.uniovi.asw.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.persistencia.GestionBD;

/**
 * 
 * @author Ana
 *Clase que lee el fichero excel con los datos de los ciudadanos
 */
public class LeerFichero {
	/**
	 * Método que lee el fichero excel
	 * @return Array de un array con los datos de los ciudadanos
	 * @throws IOException
	 */
	public static ArrayList<ArrayList<Object>> readXLSXFile() throws IOException {
		InputStream ExcelFileToRead = new FileInputStream("test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFWorkbook test = new XSSFWorkbook();

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		ArrayList<ArrayList<Object>> array = new ArrayList<ArrayList<Object>>();

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
			array.add(datos);
		}

		for (int i = 1; i < array.size(); i++) {
			for (int j = 0; j < array.get(i).size(); j++) {
				System.out.print(array.get(i).get(j) + "\t");

			}
			System.out.println();

		}
		return array;

	}

	public void guardarEnBD() {
		ArrayList<ArrayList<Object>> array = new ArrayList<ArrayList<Object>>();
		GestionBD g = new GestionBD();
		for (int i = 1; i < array.size(); i++)
			g.guardarVotanteCenso(String.valueOf(array.get(i).get(0)), String.valueOf(array.get(i).get(2)),
					String.valueOf(array.get(i).get(1)), Integer.parseInt(String.valueOf(array.get(i).get(3))));
	}

	public static void main(String[] args) throws IOException {

		readXLSXFile();

	}

}
