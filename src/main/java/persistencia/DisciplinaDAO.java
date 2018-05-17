package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Disciplina;
import model.Disciplina;;

public class DisciplinaDAO extends Manager<Disciplina>{
	
	private Disciplina disciplina;
	
	public DisciplinaDAO(Disciplina disciplina){
		this.setup();
		this.disciplina=disciplina;
	}
	@Override
    public boolean create() {
       
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.disciplina);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    
    public List<Disciplina> getAll(){     
    	
    	List<Disciplina> d;	
    	Session session = sessionFactory.openSession();
        Query disciplina = session.createQuery("from Disciplina");
        d= disciplina.getResultList();
        session.close();
        return d;
	}
 
    public Disciplina read(Object c) {
    	String codigo = (String)c;
    	Session session = sessionFactory.openSession();  
    	Disciplina d = session.get(Disciplina.class, codigo);
	    session.close();
	    return d;
    }
 
    public void update() {
        // code to modify 
    	
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(this.disciplina);
        session.getTransaction().commit();
        session.close();
       
    	
        
    }
    
    public boolean delete(Object c) {
        // code to remove
    	
    	String codigo = (String)c;
    	Disciplina d = new Disciplina();
	    d.setCodigo(codigo);
	   try {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(d);
	    session.getTransaction().commit();
	    session.close();
	    return true;
	   }catch(Exception ex) {
		   return false;
	   }
    	
    }

}