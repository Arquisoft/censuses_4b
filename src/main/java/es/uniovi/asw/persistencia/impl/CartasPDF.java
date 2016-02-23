package es.uniovi.asw.persistencia.impl;

import java.io.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import es.uniovi.asw.logica.Voter;
import es.uniovi.asw.persistencia.GeneradorCartas;

public class CartasPDF implements GeneradorCartas {
	
	private String rutaCartasPdf = "cartasPDF/";

	@Override
	public void generador(Voter votante) throws IOException, DocumentException {
		
		generarCartaPdf(votante);
	}	

	/**
	 * Constructor de la clase
	 * @param votante
	 * @throws IOException
	 * @throws DocumentException 
	 */
	public CartasPDF(Voter votante) throws IOException, DocumentException {
		
		generarCartaPdf(votante);
	}
	
	public void generarCartaPdf(Voter votante) throws FileNotFoundException, DocumentException {
				
		String rutaCarta = rutaCartasPdf + votante.getNif() + ".pdf";

		File fichero = new File(rutaCarta);
		
		if(votante.getClave().length() < 10)
		{
			GeneradorPasswordsImpl gp = new GeneradorPasswordsImpl();
			String pass = gp.generarPass(votante);
			votante.setClave(pass);
		}
		
		if (!fichero.exists())
		{
			File carpeta = new File(rutaCartasPdf);
			
			if (!carpeta.exists()) 
				carpeta.mkdir();
			
			Document documento = new Document();
			FileOutputStream ficheroPdf = new FileOutputStream(rutaCarta);
						 
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			 
			documento.open();
			documento.add(new Paragraph("Usuario: " + votante.getNombre() + "." + votante.getEmail(),
			                FontFactory.getFont("arial", 20, Font.BOLD)));       
			
			documento.add(new Paragraph(votante.getClave(),
	                FontFactory.getFont("arial", 20, Font.BOLD)));
			
			documento.close();	
		}
		else
			System.out.println("La carta en formato PDF para este usuario ya existe");
	
	}
}
