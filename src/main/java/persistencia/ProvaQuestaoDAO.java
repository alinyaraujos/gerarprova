package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.query.Query;

import model.ProvaQuestao;

import org.hibernate.Session;


public class ProvaQuestaoDAO extends Manager<ProvaQuestao>{
	
	private ProvaQuestao provaQuestoes;
	
	public ProvaQuestaoDAO(ProvaQuestao provaQuestoes){
		this.setup();
		this.provaQuestoes=provaQuestoes;
	}
 
    public boolean create() {
        try {
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(this.provaQuestoes);
        session.getTransaction().commit();
        session.close();
        return true;
        }catch(Exception e){
        	JOptionPane.showMessageDialog(null, "erro ao salvar");
        	return false;
        } 
    }
    
    public List<ProvaQuestao> getAll(){     	
    	List<ProvaQuestao> a;	
    	Session session = sessionFactory.openSession();
        Query ProvaQuestoes = session.createQuery("from Provaquestoes");
        a= ProvaQuestoes.getResultList();
        session.close();
        return a;
	}
 
    public ProvaQuestao read(Object c) {
    	int codigo = (Integer)c;
    	Session session = sessionFactory.openSession();  
    	ProvaQuestao p = session.get(ProvaQuestao.class, codigo);
	    session.close();
	    return p;
    }
 
    public void update() {
        // code to modify a professor
    	
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        
        if (this.getAll().size() > 0) {
        	session.update(this.provaQuestoes);
        	session.getTransaction().commit();
        	session.close();
        } else {
        	this.create();
        }
        
        session.update(this.provaQuestoes);
        session.getTransaction().commit();
        session.close();
    }

	@Override
	public boolean delete(Object codigo) {
		// TODO Auto-generated method stub
		return false;
	}    
    
    
}