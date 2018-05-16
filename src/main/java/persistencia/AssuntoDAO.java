package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import model.Assunto;
import model.Disciplina;

import org.hibernate.Session;


public class AssuntoDAO extends Manager{
 
    protected void create(Assunto a) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Assunto> getAll(){     	
    	List<Assunto> a;	
    	Session session = sessionFactory.openSession();
        Query Assunto = session.createQuery("from Assunto");
        a= Assunto.getResultList();
        session.close();
        return a;
	}
 
    protected Assunto read(String matricula) {
    	Session session = sessionFactory.openSession();  
    	Assunto a = session.get(Assunto.class, matricula);
	    session.close();
	    return a;
    }
 
    protected void update(Assunto a) {
        // code to modify     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();
    }
    
    protected void delete(int codigo) {
        // code to remove	
    	Assunto a = new Assunto();
	    a.setCodigo(codigo);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(a);
	    session.getTransaction().commit();
	    session.close();	
    }
}