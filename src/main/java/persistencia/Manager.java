package persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Manager {

	protected SessionFactory sessionFactory;
	 
    protected void setup() {
        // code to load Hibernate Session factory
    	
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    	
    	
    }
    
    
    protected void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }
	
	
}