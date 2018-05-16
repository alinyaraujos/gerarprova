package model;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class GeraProva {

	Document documento = new Document();
	
	
	public void geraPdf(){
	    
	    try {
	             
	              PdfWriter.getInstance(documento, new FileOutputStream("C:\\Users\\Herbert\\Documents\\Prova.pdf"));
	              documento.open();
	             
	              // adicionando um parágrafo no documento
	              for(int i=0;i<2;i++){
	              documento.add(new Paragraph("1.Esse programa é muito mito, sim ou não?"));
	              }
	}               
	          catch(DocumentException de) {
	              System.err.println(de.getMessage());
	          }catch(IOException ioe) {
	              System.err.println(ioe.getMessage());
	          }
	          documento.close();   
	    
	    
	    }
	
}
