package com.hibernate.methods;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FlushTest {

	public static void main(String[] args) {
				
		SessionFactory sessionFactory = new Configuration().configure(
				"/com/hibernate/methods/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Employee employee1=(Employee) session1.get(Employee.class, 1);
		System.out.println("employee1 Name=="+employee1.getName());
		employee1.setName("Update This Name");
		System.out.println("before commit");
		session1.getTransaction().commit();
		session1.close();	
		System.out.println("------------------");
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Employee employee2=(Employee) session2.get(Employee.class, 1);
		System.out.println("employee2 Name=="+employee2.getName());
		employee2.setName("Update This Name again");
		session2.flush();
		System.out.println("before commit");
		session2.getTransaction().commit();
		session2.close();	
		
	}

}
