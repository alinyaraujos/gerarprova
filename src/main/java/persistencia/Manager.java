package persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Manager {

	private SessionFactory sessionFactory;
	 
    public void setup() {
        // code to load Hibernate Session factory
    	
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    		System.out.println(ex.getMessage());
    		//StandardServiceRegistryBuilder.destroy(registry);
    	}    	
    }
    
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    
	public void exit() {
        // code to close Hibernate Session factory
    	this.sessionFactory.close();
    }
	
	
}