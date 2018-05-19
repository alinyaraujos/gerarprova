package persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import model.Disciplina;

public abstract class Manager <T>{

	protected SessionFactory sessionFactory;
	
	public abstract boolean create();
    
    public abstract List<T> getAll();
 
    public abstract T read(Object codigo);
 
    public abstract void update();
    
    public abstract boolean delete(Object codigo);
	

    public void setup() {

        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}	
    }
    
    public void exit() {
        // code to close Hibernate Session factory
    	this.sessionFactory.close();
    }
	
}