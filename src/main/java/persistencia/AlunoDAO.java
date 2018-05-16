package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Aluno;


public class AlunoDAO extends Manager{
 
    protected void create(Aluno a) {
        Session session = this.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Aluno> getAll(){     	
    	List<Aluno> a;	
    	Session session = this.getSessionFactory().openSession();
        Query aluno = session.createQuery("from Aluno");
        a= aluno.getResultList();
        session.close();
        return a;
	}
 
    protected Aluno read(String matricula) {
    	Session session = this.getSessionFactory().openSession();  
    	Aluno a = session.get(Aluno.class, matricula);
	    session.close();
	    return a;
    }
 
    protected void update(Aluno a) {
        // code to modify     
        Session session = this.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();
    }
    
    protected void delete(int matricula) {
        // code to remove	
    	Aluno a = new Aluno();
	    a.setMatricula(matricula);
	 
	    Session session = this.getSessionFactory().openSession();
	    session.beginTransaction();
	 
	    session.delete(a);
	    session.getTransaction().commit();
	    session.close();	
    }

}