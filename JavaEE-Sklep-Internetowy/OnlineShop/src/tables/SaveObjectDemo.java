package tables;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveObjectDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Address.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating addresss");
			Address address = new Address("Polska","Kielce","Mala","10","11","25-222");
			session.beginTransaction();
			
			System.out.println("Saving addresss");
			session.save(address);
			 
			session.getTransaction().commit();
			System.out.println("Address added!");
		
		}finally {
			factory.close();

		}
	}
}
