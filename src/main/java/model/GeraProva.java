package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import patternproject.FactoryDAO;
import persistencia.AssuntoDAO;
import persistencia.Manager;
import persistencia.QuestaoDAO;


public class GeraProva {

	private Document documento = new Document();
	private List<Questao> listQuestoes;
	
	public boolean geraPdf(int quantidade, Assunto a) throws Exception{

		QuestaoDAO questoes = new QuestaoDAO();
		listQuestoes = questoes.getByQuestaoRand(a);
	
		try {
		
			int tamanho = listQuestoes.size();
			
			if(tamanho>=quantidade) {
		        Date d = new Date();
                Calendar cal = new GregorianCalendar();
                cal.setTime(d);
                
				PdfWriter.getInstance(documento, new FileOutputStream("./"+cal.getTimeInMillis()+".pdf"));
				documento.open();
				

				documento.add(new Paragraph("Aluno(a):______________________________________"));
				documento.add(new Paragraph(" "));
				documento.add(new Paragraph(" "));
				
				for(int i=0;i<quantidade;i++){
					System.out.println(this.listQuestoes.get(i));
					
					String flag = this.listQuestoes.get(i).getAssertivaA();
	                
					if(flag.isEmpty() || flag==null){
						documento.add(new Paragraph((i+1)+"-"+this.listQuestoes.get(i).getEnunciado()));
					}else {
						documento.add(new Paragraph((i+1)+"-"+this.listQuestoes.get(i).getEnunciado()));
						documento.add(new Paragraph("A)"+this.listQuestoes.get(i).getAssertivaA()));
						documento.add(new Paragraph("B)"+this.listQuestoes.get(i).getAssertivaB()));
						documento.add(new Paragraph("C)"+this.listQuestoes.get(i).getAssertivaC()));
						documento.add(new Paragraph("D)"+this.listQuestoes.get(i).getAssertivaD()));
						documento.add(new Paragraph("E)"+this.listQuestoes.get(i).getAssertivaE()));
					}
				}
			}else{
				return false;
			}
		}               
		catch(DocumentException de) {
			System.err.println(de.getMessage());
			documento.close();
		}catch(IOException ioe) {
			System.err.println(ioe.getMessage());
			documento.close();
		}
		
		documento.close();   
		return true;
	}
	
}
