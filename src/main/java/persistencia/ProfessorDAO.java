package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
	
    public  boolean create() {
    	try {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.professor);
        session.getTransaction().commit();
        session.close();
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "erro ao salvar");
    		return false;
    	} 
    	return true;
    }
    
    public List<Professor> getAll(){     
    	
    	List<Professor> p;	
    	Session session = sessionFactory.openSession();
    	
        Query professor = session.createQuery("from Professor");
        p= professor.getResultList();
        session.close();
        return p;
	}
 
    public Professor read(Object cpfProfessor) {
    	String cpf = (String)cpfProfessor;
    	Session session = sessionFactory.openSession();  
	    
	    Professor p = session.get(Professor.class, cpf);
	 
	    System.out.println("Nome: " + p.getNome());
	    System.out.println("Email: " + p.getEmail());
	    System.out.println("Instituicao: " + p.getCpf());
	    session.close();
	    return p;
    }
 
    public void update() {
        // code to modify a professor
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(this.professor);
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