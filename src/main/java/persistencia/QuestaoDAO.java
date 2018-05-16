package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Professor;
import model.Questao;


public class QuestaoDAO extends Manager{
 
    protected void create(Questao q) {
        Session session = this.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(q);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Questao> getAll(){     
    	
    	List<Questao> q;
    	
    	Session session = this.getSessionFactory().openSession();
    	
        Query professor = session.createQuery("from Questao");
        q = professor.getResultList();
        session.close();
        
        return q;
	}
 
    protected Questao read(int codigo) {
    	Session session = this.getSessionFactory().openSession();
    	
    	Questao q = session.get(Questao.class, codigo);
    	
	    session.close();
	    
	    return q;
    }
    
    protected List<Questao> getBySubject(int subjectCode){
    	List<Questao> questions = null;
    	
    	Session session = this.getSessionFactory().openSession();
    	
    	questions = session.createQuery("from Questao").getResultList();
    	
    	session.close();
    	
    	return questions;
    }
 
    protected void update(Questao qNew) {
        // code to modify a questao
    	
    	Questao q = this.read(qNew.getCodigo());

        if (qNew.getEnunciado() != null)
        	q.setEnunciado(qNew.getEnunciado());
        
        if (qNew.getNivel() != null)
        	q.setNivel(qNew.getNivel());
        
        if (qNew.getAssertivaA() != null)
        	q.setAssertivaA(qNew.getAssertivaA());
        
        if (qNew.getAssertivaB() != null)
        	q.setAssertivaB(qNew.getAssertivaB());
        
        if (qNew.getAssertivaC() != null)
        	q.setAssertivaC(qNew.getAssertivaC());
        
        if (qNew.getAssertivaD() != null)
        	q.setAssertivaD(qNew.getAssertivaD());
        
        if (qNew.getAssertivaE() != null)
        	q.setAssertivaE(qNew.getAssertivaE());
        
        if (qNew.getCodAssunto() != 0)
        	q.setCodAssunto(qNew.getCodAssunto());
        
        Session session = this.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(q);
        session.getTransaction().commit();
        session.close();
    	 
    }
    
    protected void delete(int codigo) {
        // code to remove a book	
    	Questao q = new Questao();
	    q.setCodigo(codigo);
	 
	    Session session = this.getSessionFactory().openSession();
	    session.beginTransaction();
	 
	    session.delete(q);
	 
	    session.getTransaction().commit();
	    session.close();
    	
    }
    
    public static void main(String[] args) {
        // code to run the program   	
    	QuestaoDAO bm = new QuestaoDAO();
    	bm.setup();
        
    	Questao q = new Questao();
    	q.setCodigo(4325);
    	q.setNivel("Ensino Superior");
    	
    	bm.update(q);
    	
        bm.exit();
        
    }
}