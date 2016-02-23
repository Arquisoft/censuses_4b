package es.uniovi.asw.persistencia;

import java.io.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import es.uniovi.asw.logica.Voter;

/**
 * Clase que genera las cartas de los votantes con su usuario y su clave
 * 
 * @author Adrian
 */
public class Generador implements GeneradorCartas {
	
	private String rutaCartasTxt = "cartasTXT/";
	private String rutaCartasPdf = "cartasPDF/";
		
	@Override
	public void generador(Voter votante) throws IOException, DocumentException {

		generarCarta(votante);
	}	
	
	/**
	 * Constructor de la clase
	 * @param votante
	 * @throws IOException
	 * @throws DocumentException 
	 */
	public Generador(Voter votante) throws IOException, DocumentException {
		
		generarCarta(votante);
	}

	public void generarCartaPdf(Voter votante, String pass) throws FileNotFoundException, DocumentException {
		
		String rutaCarta = rutaCartasPdf + votante.getNif() + ".pdf";

		Document documento = new Document();
		FileOutputStream ficheroPdf = new FileOutputStream(rutaCarta);
					 
		PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
		 
		documento.open();
		documento.add(new Paragraph("Usuario: " + votante.getNombre() + "." + votante.getEmail(),
		                FontFactory.getFont("arial", 20, Font.BOLD)));       
		
		documento.add(new Paragraph(pass,
                FontFactory.getFont("arial", 20, Font.BOLD)));
		
		documento.close();	
	}

	/**
	 * Metodo principal que genera la carta
	 * @param votante
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public void generarCarta(Voter votante) throws IOException, DocumentException {

		String rutaCarta = rutaCartasTxt + votante.getNif() + ".txt";

		File fichero = new File(rutaCarta);
		
		if (!fichero.exists())
		{
	        BufferedWriter carta = new BufferedWriter(new FileWriter(new 
	        		File(rutaCartasTxt + votante.getNif() + ".txt")));
	            
	        carta.write("Usuario: " + votante.getNombre() + "." + votante.getEmail());
			String pass = "\nClave: " + generarPassword(votante);
	        carta.write(pass);
	        
			carta.close();
			
			generarCartaPdf(votante, pass);
		}
		else
			System.out.println("La carta para este usuario ya existe");
	}
	
	/**
	 * Método que genera la clave del usuario
	 * @param votante
	 * @return pass, devuelve la clave
	 */
	private String generarPassword(Voter votante) {

		int i, valor;
		char[] codigo = new char[10];
		char[] elementos = {'0','1','2','3','4','5','6','7','8','9',
						'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
						'o','p','q','r','s','t','u','v','w','x','y','z',
						'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
						'O','P','Q','R','S','T','U','V','W','X','Y','Z',
						'*','+','.',','};
		
		for(i = 0; i < codigo.length; i++){
			valor = (int)(Math.random() * elementos.length);
			codigo[i] = (char)elementos[valor];
		}
		
		return new String(codigo);
	}
}