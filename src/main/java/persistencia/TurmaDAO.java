package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Prova;
import model.Turma;


public class TurmaDAO extends Manager<Turma>{
	
	private Turma turma;
	
	public TurmaDAO(Turma turma){
		this.setup();
		this.turma=turma;
	}
 
    public boolean create() {
       
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.turma);
        session.getTransaction().commit();
        session.close();
      return true;
    }
    
    public List<Turma> getAll(){     
    	
    	List<Turma> t;	
    	Session session = sessionFactory.openSession();
    	
        Query Turma = session.createQuery("from Turma");
        t= Turma.getResultList();
        session.close();
        return t;
	}
 
    public Turma read(Object c) {
    	String codigo = (String)c;
    	Session session = sessionFactory.openSession();  
	    
	    Turma t = session.get(Turma.class, codigo);
	    session.close();
	    return t;
    }
 
    public void update() {
        // code to modify a Turma
    	
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(this.turma);
        session.getTransaction().commit();
        session.close();
      
    }
    
    public boolean delete(Object c) {
        // code to remove a Turma
    	String codigo = (String)c;
    	Turma t = new Turma();
	    t.setCodigo(codigo);
	    
	    try {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(t);
	 
	    session.getTransaction().commit();
	    session.close();
	    return true;
	    }catch(Exception ex) {
	    	return false;
	    }
    }
}