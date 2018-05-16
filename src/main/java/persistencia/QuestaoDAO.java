package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Questao;


public class QuestaoDAO extends Manager{
 
    protected void create(Questao q) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(q);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Questao> getAll(){     
    	
    	List<Questao> q;
    	
    	Session session = sessionFactory.openSession();
    	
        Query professor = session.createQuery("from Questao");
        q = professor.getResultList();
        session.close();
        
        return q;
	}
 
    protected void read() {
    	Session session = sessionFactory.openSession();
	    session.close();
    }
 
    protected void update(Questao q) {
        // code to modify a questao
        q.setCodigo(q.getCodigo());
        q.setEnunciado(q.getEnunciado());
        q.setNivel(q.getNivel());
        q.setAssertivaA(q.getAssertivaA());
        q.setAssertivaB(q.getAssertivaB());
        q.setAssertivaC(q.getAssertivaC());
        q.setAssertivaD(q.getAssertivaD());
        q.setAssertivaE(q.getAssertivaE());
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(q);
        session.getTransaction().commit();
        session.close();
    	 
    }
 
    protected void delete(Questao q) {
    	Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(q);
	 
	    session.getTransaction().commit();
	    session.close();
    }
    
    protected void delete(int codigo) {
        // code to remove a book	
    	Questao q = new Questao();
	    q.setCodigo(codigo);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(q);
	 
	    session.getTransaction().commit();
	    session.close();
    	
    }
    
    public static void main(String[] args) {
        // code to run the program
    	
    	String[] assertivas = {"Bral", "Brel", "Bril", "Brol", "Brão"};
    	
    	Questao q = new Questao();
    	q.cadastrar(1235, "Quem descobriu o Brasil ? Pedro Álvares Ca...", "Ensino Médio", "Assertiva A", assertivas, 1);
    	
    	String[] assertivas2 = {"Bral", "Brel", "Bril", "Brol", "Brão"};
    	
    	Questao q2 = new Questao();
    	q2.cadastrar(4325, "Quem é o presidente do Brasil ?", "Ensino Médio", "Assertiva D", assertivas2, 2);
    	
    	QuestaoDAO bm = new QuestaoDAO();
    	bm.setup();
    	bm.create(q);
    	bm.create(q2);
    	//bm.exit();
    	
    
        for (Object p : bm.getAll()){
        	System.out.println(((Questao)q).getEnunciado());
        }
        
        bm.exit();
    }
}