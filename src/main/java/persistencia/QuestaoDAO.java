package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Professor;
import model.Prova;
import model.Questao;


public class QuestaoDAO extends Manager<Questao>{
	
	private Questao questao;
	
	public QuestaoDAO(Questao questao){
		this.setup();
		this.questao=questao;
	}
 
    public boolean create() {
     
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.questao);
        session.getTransaction().commit();
        session.close();
       return true;
    }
    
    public List<Questao> getAll(){     
    	
    	List<Questao> q;
    	
    	Session session = sessionFactory.openSession();
    	
        Query professor = session.createQuery("from Questao");
        q = professor.getResultList();
        session.close();
        
        return q;
	}
 
    public Questao read(Object c) {
    	
    	int codigo = (Integer)c;
    	Session session = sessionFactory.openSession();
    	Questao q = session.get(Questao.class, codigo);
    	
	    session.close();
	    
	    return q;
    }
    
    public List<Questao> getBySubject(int subjectCode){
    	List<Questao> questions = null;
    	
    	Session session = sessionFactory.openSession();
    	
    	questions = session.createQuery("from Questao").getResultList();
    	
    	session.close();
    	
    	return questions;
    }
 
    public void update() {
        // code to modify a questao
    	
    	Questao qNew = this.questao;
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
    
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(q);
        session.getTransaction().commit();
        session.close();
        
    	
    }
    
    public boolean delete(Object c) {
        // code to remove a book	
    	int codigo = (Integer)c;
    	Questao q = new Questao();
	    q.setCodigo(codigo);
	    
	    try {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(q);
	 
	    session.getTransaction().commit();
	    session.close();
	    return true;
	    }catch(Exception ex){
	    	return false;
	    }
    }
}