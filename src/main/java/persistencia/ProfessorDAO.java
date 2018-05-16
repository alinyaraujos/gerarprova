package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Assunto;
import model.Professor;


public class ProfessorDAO extends Manager<Professor>{
	
	private Professor professor;
	
	public ProfessorDAO(Professor professor) {
		this.setup();
		this.professor=professor;
	}
	
    public void create() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.professor);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Professor> getAll(){     
    	
    	List<Professor> p;	
    	Session session = sessionFactory.openSession();
    	
        Query professor = session.createQuery("from Professor");
        p= professor.getResultList();
        session.close();
        return p;
	}
 
    public Professor read(Object professor) {
    	String cpf = ((Professor) professor).getCpf();
    	Session session = sessionFactory.openSession();  
	    
	    Professor p = session.get(Professor.class, cpf);
	 
	    session.close();
	    return p;
    }
 
    public void update() {
        // code to modify a professor
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        if (this.read(this.professor) != null) 
        	session.update(this.professor);
        else
        	this.create();
        
        
        session.getTransaction().commit();
        session.close();
    }
    
    public void delete(Object cpfProfessor) {
        // code to remove	
    	String cpf = (String)cpfProfessor;
    	Professor p = new Professor();
	    p.setCpf(cpf);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(p);
	 
	    session.getTransaction().commit();
	    
	    session.close();	
    	
    }
}