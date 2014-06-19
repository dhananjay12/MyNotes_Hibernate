package com.hibernate.objectStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateObjectStatesTest {

	public static void main(String[] args) {
		System.out.println("HibernateTest");
		Employee aEmployee = new Employee();
		aEmployee.setName("Employee Name1");
		// point1
		SessionFactory sessionFactory = new Configuration().configure(
				"/com/hibernate/objectStates/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(aEmployee);
		
		aEmployee.setName("Employee Update 1");
		aEmployee.setName("Employee Update 2");
		// point2
		session.getTransaction().commit();
		session.close();
		// point3
		aEmployee.setName("Employee Update 3");
	}

}
