package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.util.List;
import java.util.Random;

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
	
	public void geraPdf(int quantidade, Assunto a){
		
		Random gerador = new Random();
		QuestaoDAO questoes = new QuestaoDAO();
		listQuestoes = questoes.getByAssunto(a);
	
		try {
			
			PdfWriter.getInstance(documento, new FileOutputStream("/home/vitor/Área de Trabalho/Prova.pdf"));
			documento.open();
			int tamanho = listQuestoes.size();
			if(tamanho>=quantidade) {
				for(int i=0;i<quantidade;i++){
					int sorteio = gerador.nextInt(tamanho);
					
					System.out.println(this.listQuestoes.get(sorteio));
					
					String flag = this.listQuestoes.get(sorteio).getAssertivaA();
					
					if(flag.isEmpty() || flag==null){
						documento.add(new Paragraph((i+1)+"-"+this.listQuestoes.get(sorteio).getEnunciado()));
					}else {
						documento.add(new Paragraph((i+1)+"-"+this.listQuestoes.get(sorteio).getEnunciado()));
						documento.add(new Paragraph("A)"+this.listQuestoes.get(sorteio).getAssertivaA()));
						documento.add(new Paragraph("B)"+this.listQuestoes.get(sorteio).getAssertivaB()));
						documento.add(new Paragraph("C)"+this.listQuestoes.get(sorteio).getAssertivaC()));
						documento.add(new Paragraph("D)"+this.listQuestoes.get(sorteio).getAssertivaD()));
						documento.add(new Paragraph("E)"+this.listQuestoes.get(sorteio).getAssertivaE()));
					}
				}
			}else{
				System.out.println("erro");
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
