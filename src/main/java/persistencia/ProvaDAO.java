package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.query.Query;
import org.hibernate.Session;

import model.Assunto;
import model.Prova;


public class ProvaDAO extends Manager<Prova>{
	
	private Prova prova;
	private int codId;
	
	public ProvaDAO(Prova prova){
		this.setup();
		this.prova=prova;
	}
 
    /* public boolean create() {
        try {
	    	Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        session.save(this.prova);
	        session.getTransaction().commit();
	        System.out.println();
	        session.close();
	        return true;
        }catch(Exception e){
        	JOptionPane.showMessageDialog(null, "erro ao salvar");
        	return false;
        } 
    }
    */
    
    
    public boolean create() {
        try {
        	Integer codID = null;
	    	Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        codID = (Integer)session.save(this.prova);
	        session.getTransaction().commit();
	        session.close();
	        this.codId = codID;
	        return true;
        }catch(Exception e){
        	JOptionPane.showMessageDialog(null, "erro ao salvar");
        	return false;
        } 
    }
    
    public List<Prova> getAll(){     	
    	List<Prova> a;	
    	Session session = sessionFactory.openSession();
        Query Prova = session.createQuery("from Prova");
        a= Prova.getResultList();
        session.close();
        return a;
	}
 
    public Prova read(Object c) {
    	int codigo = (Integer)c;
    	Session session = sessionFactory.openSession();  
    	Prova p = session.get(Prova.class, codigo);
	    session.close();
	    return p;
    }
 
    public boolean update() {
        // code to modify
    	try {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(this.prova);
        session.getTransaction().commit();
        session.close();
        return true;
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "erro ao fazer update");
    		return false;
    	} 
    	
    }
    
    public boolean delete(Object c) {
        // code to remove
    	
    	int codigo = (Integer)c;
    	Prova p = new Prova();
	    p.setCodigo(codigo);
	    try {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(p);
	    session.getTransaction().commit();
	    session.close();
	    return true;
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "erro ao deletar");
    		return false;
    	} 
    }    
    
    public int getCodigo() {
    	return this.codId;
    }
    
}