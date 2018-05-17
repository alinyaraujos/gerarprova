package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.query.Query;

import model.Aluno;
import model.Assunto;
import model.Disciplina;

import org.hibernate.Session;


public class AssuntoDAO extends Manager<Assunto>{
	
	private Assunto assunto;
	
	public AssuntoDAO(Assunto assunto){
		this.setup();
		this.assunto=assunto;
	}
	
    public boolean create() {
        try {
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.assunto);
        session.getTransaction().commit();
        session.close();
        return true;
        }catch(Exception e){
        	JOptionPane.showMessageDialog(null, "erro ao salvar");
        	return false;
        } 
    }
    
    public List<Assunto> getAll(){     	
    	List<Assunto> a;
    
    	Session session = sessionFactory.openSession();
        Query Assunto = session.createQuery("from Assunto");
        a= Assunto.getResultList();
        session.close();
        return a;
	}
    
    public List<Assunto> getByDisciplina(Disciplina d){     	
    	List<Assunto> a;	
    	Session session = sessionFactory.openSession();
        Query assunto = session.createQuery("from Assunto where cod_disciplina = :cod").setParameter("cod", d.getCodigo());
        a = assunto.getResultList();
        session.close();
        
        return a;
	}
 
    public Assunto read(Object m) {
    	int matricula = (Integer) m;
    	Session session = sessionFactory.openSession();  
    	Assunto a = session.get(Assunto.class, matricula);
	    session.close();
	    return a;
    }
 
    public boolean update() {
        try {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(this.assunto);
        session.getTransaction().commit();
        session.close();
        return true;
        }catch(Exception e){
    		JOptionPane.showMessageDialog(null, "erro ao fazer update");
    		return false;
    	} 
    	
    }
    
    public boolean delete(Object c) {
    	int codigo = (Integer) c;
        // code to remove
    	
    	Assunto a = new Assunto();
	    a.setCodigo(codigo);
	    try {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(a);
	    session.getTransaction().commit();
	    session.close();
	    return true;
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "erro ao deletar");
    		return false;
    	} 
    	
    }
}