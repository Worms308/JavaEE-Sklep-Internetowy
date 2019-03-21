package utilities;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class DBConfig implements ServletContextListener {

	private static EntityManagerFactory factory;

    public void contextDestroyed(ServletContextEvent sce)  { 
         if (factory != null && factory.isOpen())
        	 factory.close();
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("Uruchomienie aplikacji: " + new Date());
        factory = Persistence.createEntityManagerFactory("OnlineShop");
    }
    
    public static EntityManager createEntityManager() {
		if (factory != null)
			return factory.createEntityManager();
		else
			return null;
	}
	
}
