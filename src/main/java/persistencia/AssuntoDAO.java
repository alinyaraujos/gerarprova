package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.query.Query;

import model.Aluno;
import model.Assunto;
import model.Disciplina;

import org.hibernate.Session;


public class AssuntoDAO extends Manager<Assunto>{
	
	private Assunto assunto;
	
	public AssuntoDAO(Assunto assunto){
		this.setup();
		this.assunto=assunto;
	}
	
    public boolean create() {
        
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.assunto);
        session.getTransaction().commit();
        session.close();
      return true;
    }
    
    public List<Assunto> getAll(){     	
    	List<Assunto> a;
    
    	Session session = sessionFactory.openSession();
        Query Assunto = session.createQuery("from Assunto");
        a= Assunto.getResultList();
        session.close();
        return a;
	}
 
    public Assunto read(Object m) {
    	int matricula = (Integer) m;
    	Session session = sessionFactory.openSession();  
    	Assunto a = session.get(Assunto.class, matricula);
	    session.close();
	    return a;
    }
 
    public void update() {
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(this.assunto);
        session.getTransaction().commit();
        session.close();
      
    }
    
    public boolean delete(Object c) {
    	int codigo = (Integer) c;
        // code to remove
    	
    	Assunto a = new Assunto();
	    a.setCodigo(codigo);
	    try {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(a);
	    session.getTransaction().commit();
	    session.close();
	    return true;
	    }catch(Exception ex) {
	    	return false;
	    }
    	
	    
	   }
}