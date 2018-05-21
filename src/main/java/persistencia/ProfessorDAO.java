package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Assunto;
import model.Professor;

public class ProfessorDAO extends Manager<Professor>{
	public Query getQuery() {
		return null;
	}
	private Professor professor;
	
	public ProfessorDAO(Professor professor) {
		this.setup();
		this.professor=professor;
	}
	
    public boolean create() {
    	
    	try {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(this.professor);
        session.getTransaction().commit();
        session.close();
        return true;
    	}catch(Exception ex) {
    		return false;
    	}
        
       
    }
    
    public List<Professor> getAll(){     
    	
    	List<Professor> p = null;	
    	try {
    	Session session = sessionFactory.openSession();
        Query professor = session.createQuery("from Professor");
        p = professor.getResultList();
        session.close();
        return p;
    	}catch(Exception ex) {
    		JOptionPane.showMessageDialog(null, "Erro de sele��o");
    	}
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
        
        if (this.getAll().size() > 0) {
        	session.update(this.professor);
        	session.getTransaction().commit();
        } else {
        	this.create();
        }
        
        session.close();
    }
    
    public boolean delete(Object cpfProfessor) {
        // code to remove
    	
    	String cpf = (String)cpfProfessor;
    	Professor p = new Professor();
	    p.setCpf(cpf);
	   
	   try {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.delete(p);
	    session.getTransaction().commit();
	    session.close();
	    return true;
	   }catch(Exception ex) {
		   return false;
	   }
    	
    }
}