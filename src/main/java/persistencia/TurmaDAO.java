package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Turma;


public class TurmaDAO extends Manager{
 
    protected void create(Turma t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Turma> getAll(){     
    	
    	List<Turma> t;	
    	Session session = sessionFactory.openSession();
    	
        Query Turma = session.createQuery("from Turma");
        t= Turma.getResultList();
        session.close();
        return t;
	}
 
    protected Turma read(String codigo) {
    	Session session = sessionFactory.openSession();  
	    
	    Turma t = session.get(Turma.class, codigo);
	    session.close();
	    return t;
    }
 
    protected void update(Turma t) {
        // code to modify a Turma
        t.setCodigo(t.getCodigo());
        t.setAno(t.getAno());
        t.setSemestre(t.getSemestre());;
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }
    
    protected void delete(String codigo) {
        // code to remove a Turma	
    	Turma t = new Turma();
	    t.setCodigo(codigo);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(t);
	 
	    session.getTransaction().commit();
	    session.close();	
    }
}