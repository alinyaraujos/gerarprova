package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Assunto;
import model.Prova;


public class ProvaDAO extends Manager<Prova>{
	
	private Prova prova;
	
	public ProvaDAO(Prova prova){
		this.setup();
		this.prova=prova;
	}
 
    public void create() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.prova);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Prova> getAll(){     	
    	List<Prova> a;	
    	Session session = sessionFactory.openSession();
        Query Prova = session.createQuery("from Prova");
        a= Prova.getResultList();
        session.close();
        return a;
	}
 
    public Prova read(Object c) {
    	int codigo = (Integer)c;
    	Session session = sessionFactory.openSession();  
    	Prova p = session.get(Prova.class, codigo);
	    session.close();
	    return p;
    }
 
    public void update() {
        // code to modify     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(this.prova);
        session.getTransaction().commit();
        session.close();
    }
    
    public void delete(Object c) {
        // code to remove	
    	int codigo = (Integer)c;
    	Prova p = new Prova();
	    p.setCodigo(codigo);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(p);
	    session.getTransaction().commit();
	    session.close();	
    }    
    
}