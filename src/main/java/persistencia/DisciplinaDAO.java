package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Disciplina;;


public class DisciplinaDAO extends Manager{
 
    protected void create(Disciplina d) {
        Session session = this.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(d);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Disciplina> getAll(){     
    	
    	List<Disciplina> d;	
    	Session session = this.getSessionFactory().openSession();
        Query disciplina = session.createQuery("from Professor");
        d= disciplina.getResultList();
        session.close();
        return d;
	}
 
    protected Disciplina read(String codigo) {
    	Session session = this.getSessionFactory().openSession();  
    	Disciplina d = session.get(Disciplina.class, codigo);
	    session.close();
	    return d;
    }
 
    protected void update(Disciplina d) {
        // code to modify
        d.setCodigo(d.getCodigo());;
        d.setNome(d.getNome());
        d.setCpfProfessor(d.getCpfProfessor());
     
        Session session = this.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(d);
        session.getTransaction().commit();
        session.close();
    }
    
    protected void delete(String codigo) {
        // code to remove	
    	Disciplina d = new Disciplina();
	    d.setCodigo(codigo);
	 
	    Session session = this.getSessionFactory().openSession();
	    session.beginTransaction();
	 
	    session.delete(d);
	    session.getTransaction().commit();
	    session.close();	
    }
}