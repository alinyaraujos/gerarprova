package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import patternproject.FactoryDAO;
import persistencia.Manager;
import persistencia.ProvaDAO;
import persistencia.QuestaoDAO;


public class GeraProva {

	private Document documento = new Document();
	private FactoryDAO<Prova> fpProva;
	private FactoryDAO<ProvaQuestao> fpQuestao;
	private List<Questao> listQuestoes;
	private Prova prova;
	private ProvaQuestao provaQuestao;
	private QuestaoDAO questoes;
	
	public boolean geraPdf(int quantidade, Assunto a, String apelido) throws Exception{
		
		if(this.listQuestoes.size()==0) {
			this.questoes = new QuestaoDAO();
			listQuestoes = questoes.getByQuestaoRand(a);
		}
		try {
			if(listQuestoes.size()>=quantidade) { 
                if(apelido.isEmpty()) {
	            	Date d = new Date();
	                Calendar cal = new GregorianCalendar();
	                cal.setTime(d);
                	cal.getTimeInMillis();
                }
                
				PdfWriter.getInstance(documento, new FileOutputStream("./"+apelido+".pdf"));
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
	
	public boolean salvaProva(int quantidade, Assunto a, String codTurma, String apelido) throws FileNotFoundException {
		
		int idCod;
		int tamanho;
		this.fpProva 	  = new FactoryDAO<Prova>();
		this.fpQuestao    = new FactoryDAO<ProvaQuestao>();
		this.prova 		  = new Prova();
		this.provaQuestao = new ProvaQuestao();
		this.questoes 	  = new QuestaoDAO();
		
		listQuestoes = questoes.getByQuestaoRand(a);
		tamanho=listQuestoes.size();
		
		prova.cadastrar(apelido, codTurma);
		
		if(tamanho>=quantidade) {
			Manager<Prova> provaManager = fpProva.getObjectDAO(this.prova);
			provaManager.create();
			provaManager.exit();
			idCod = ((ProvaDAO)provaManager).getCodigo();
			
			System.out.println("id"+idCod);
			for(int i=0;i<quantidade;i++){
				System.out.println(listQuestoes.get(i).getCodigo());
				provaQuestao.cadastrar(listQuestoes.get(i).getCodigo(), idCod);
				Manager<ProvaQuestao> provaQManager = fpQuestao.getObjectDAO(this.provaQuestao);
				provaQManager.create();
				provaQManager.exit();
			}
			
			return true;
		}
		return false;
	}
	
}
