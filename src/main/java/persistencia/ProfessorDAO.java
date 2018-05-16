package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Professor;


public class ProfessorDAO extends Manager{
 
    protected void create(Professor p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p);
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
 
    protected Professor read(String cpf) {
    	Session session = sessionFactory.openSession();  
	    
	    Professor p = session.get(Professor.class, cpf);
	 
	    System.out.println("Nome: " + p.getNome());
	    System.out.println("Email: " + p.getEmail());
	    System.out.println("Instituicao: " + p.getCpf());
	    session.close();
	    return p;
    }
 
    protected void update(Professor p) {
        // code to modify a professor
        p.setCpf(p.getCpf());
        p.setNome(p.getNome());
        p.setEmail(p.getEmail());
        p.setInstituicao(p.getInstituicao());
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(p);
        session.getTransaction().commit();
        session.close();
    }
    
    protected void delete(String cpf) {
        // code to remove	
    	Professor p = new Professor();
	    p.setCpf(cpf);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(p);
	 
	    session.getTransaction().commit();
	    session.close();	
    }
}