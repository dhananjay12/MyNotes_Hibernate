package com.hibernate.methods;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetAndLoadTest {

	public static void main(String[] args) {
				
		SessionFactory sessionFactory = new Configuration().configure(
				"/com/hibernate/methods/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Employee employee1=(Employee) session1.get(Employee.class, 2);
		System.out.println("get call finished");
		session1.getTransaction().commit();
		session1.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		System.out.println("calling load");
		Employee employee2=(Employee) session2.load(Employee.class, 2);
		System.out.println("load call finished");
		System.out.println(employee2.getId());
		System.out.println("load call finished");
		session2.getTransaction().commit();
		session2.close();
		
		Session session3 = sessionFactory.openSession();
		session3.beginTransaction();
		Employee employee=(Employee) session3.get(Employee.class, 2);
		System.out.println("calling load");
		Employee employee3=(Employee) session3.load(Employee.class, 2);
		System.out.println("load call finished");
		System.out.println(employee3.getName());
		session3.getTransaction().commit();
		session3.close();
		
		Session session4 = sessionFactory.openSession();
		session4.beginTransaction();
		Employee employee4=(Employee) session4.get(Employee.class, 123);
		System.out.println("get call finished");
		System.out.println(employee4);
		session4.getTransaction().commit();
		session4.close();
		
		Session session5 = sessionFactory.openSession();
		session5.beginTransaction();
		System.out.println("calling load");
		Employee employee5=(Employee) session5.load(Employee.class, 123);
		System.out.println("load call finished");
		System.out.println(employee5);
		session5.getTransaction().commit();
		session5.close();
	}

}
