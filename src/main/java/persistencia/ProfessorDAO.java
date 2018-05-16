package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
 
    protected void read() {
    	Session session = sessionFactory.openSession();
	    session.close();
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
 
    protected void delete(Professor p) {
    }
    
    protected void delete(String cpf) {
        // code to remove a book	
    	Professor p = new Professor();
	    p.setCpf(cpf);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(p);
	 
	    session.getTransaction().commit();
	    session.close();
    	
    }
    
    public static void main(String[] args) {
        // code to run the program
    	
    	Professor b = new Professor();
    	b.cadastrar("232333423", "paulo", "apaualo@jksdkjf", "UFAL");
    	
    	ProfessorDAO bm = new ProfessorDAO();
    	bm.setup();
    	bm.create(b);
    	bm.exit();
    	
    
        for (Object p : bm.getAll()){
        	System.out.println(((Professor)p).getNome());
        }
        bm.exit();
    }
}