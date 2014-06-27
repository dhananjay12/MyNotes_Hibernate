package com.hibernate.firstLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFirstLevelCacheTest {

	public static void main(String[] args) {
				
		SessionFactory sessionFactory = new Configuration().configure(
				"/com/hibernate/firstLevelCache/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Employee employee1=(Employee) session1.get(Employee.class, 2);
		System.out.println(employee1);
		//session1.evict(employee1);
		//session1.clear();
		Employee employee2=(Employee) session1.get(Employee.class, 2);
		System.out.println(employee2);
		session1.getTransaction().commit();
		session1.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Employee employee3=(Employee) session2.get(Employee.class, 2);
		System.out.println(employee3);		
		session2.getTransaction().commit();
		session2.close();
	}

}
