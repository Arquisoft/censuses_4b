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

public class LeerFichero {
		public static void readXLSXFile() throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream("test.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		ArrayList<ArrayList<Object>> array= new ArrayList<ArrayList<Object>>();
		GestionBD g = new GestionBD();
		
		
		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			ArrayList<Object> datos= new ArrayList<Object>();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					//System.out.print(cell.getStringCellValue()+" ");
					datos.add(cell.getStringCellValue());
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					//System.out.print(cell.getNumericCellValue()+" ");
					datos.add(cell.getNumericCellValue());
				}
				else
				{
					System.out.println("No está especificado el tipo");
				}
				
			}
			//System.out.println();
			array.add(datos);

		}
		for(int i=0;i<array.size();i++){
			for(int j=0;j<array.get(i).size();j++){
				System.out.print(array.get(i).get(j)+"\t");
				
			}
			System.out.println();
			g.guardarVotanteDatosCompletos(String.valueOf(array.get(i).get(0)), String.valueOf(array.get(i).get(2)), 
					String.valueOf(array.get(i).get(1)), Integer.parseInt(String.valueOf(array.get(i).get(3))), "", "");
			
		
		}
	
	}
	

	public static void main(String[] args) throws IOException {
		
		readXLSXFile();

	}

}

