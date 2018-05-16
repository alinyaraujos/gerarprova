package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Aluno;


public class AlunoDAO extends Manager<Aluno>{
 
	
	private Aluno aluno;
	
	public AlunoDAO(Aluno aluno){
		this.setup();
		this.aluno=aluno;
	}
	
    public void create() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.aluno);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Aluno> getAll(){     	
    	List<Aluno> a;	
    	Session session = sessionFactory.openSession();
        Query aluno = session.createQuery("from Aluno");
        a= aluno.getResultList();
        session.close();
        return a;
	}
 
    public Aluno read(Object m) {
    	int matricula = (Integer) m;
    	Session session = sessionFactory.openSession();  
    	Aluno a = session.get(Aluno.class, matricula);
	    session.close();
	    return a;
    }
 
    public void update() {
        // code to modify     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(this.aluno);
        session.getTransaction().commit();
        session.close();
    }
    
    public void delete(Object m) {
    	int matricula = (Integer) m;
        // code to remove	
    	Aluno a = new Aluno();
	    a.setMatricula(matricula);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(a);
	    session.getTransaction().commit();
	    session.close();	
    }

}