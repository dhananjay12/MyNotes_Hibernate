package com.hibernate.secondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSecondLevelCacheTest {

	public static void main(String[] args) {
				
		SessionFactory sessionFactory = new Configuration().configure(
				"/com/hibernate/secondLevelCache/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Employee employee1=(Employee) session1.get(Employee.class, 2);
		System.out.println(employee1);
		session1.getTransaction().commit();
		session1.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Employee employee2=(Employee) session2.get(Employee.class, 2);
		System.out.println(employee2);		
		session2.getTransaction().commit();
		session2.close();
	}

}
