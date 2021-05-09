package com.ibm;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		Employee e1 = new Employee();
		e1.setId(101);
		e1.setFirstName("Pravalika");
		e1.setLastName("Erukulla");
		Session session = sessionFactory.openSession();
		session.persist(e1);
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully Saved");
	}

}