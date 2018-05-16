package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Prova;


public class ProvaDAO extends Manager{
 
    protected void create(Prova p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p);
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
 
    protected Prova read(String codigo) {
    	Session session = sessionFactory.openSession();  
    	Prova p = session.get(Prova.class, codigo);
	    session.close();
	    return p;
    }
 
    protected void update(Prova p) {
        // code to modify     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(p);
        session.getTransaction().commit();
        session.close();
    }
    
    protected void delete(int codigo) {
        // code to remove	
    	Prova p = new Prova();
	    p.setCodigo(codigo);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(p);
	    session.getTransaction().commit();
	    session.close();	
    }
    
    
    public static void main(String[] args) {
        // code to run the program
    	
    	Prova b = new Prova();
    	b.cadastrar(22234, "sdfdsf", "2013.INFO-T", null);
    	
    	ProvaDAO bm = new ProvaDAO();
    	bm.setup();
    	bm.create(b);
    	//bm.exit();
        
        bm.exit();
    }
    
    
}