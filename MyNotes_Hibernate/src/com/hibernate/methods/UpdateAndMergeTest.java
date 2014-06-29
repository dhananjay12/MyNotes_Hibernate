package com.hibernate.methods;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateAndMergeTest {

	public static void main(String[] args) {
				
		SessionFactory sessionFactory = new Configuration().configure(
				"/com/hibernate/methods/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Employee employee1=(Employee) session1.get(Employee.class, 4);
		session1.getTransaction().commit();
		session1.close();
		System.out.println(employee1.getId());
		System.out.println(employee1.getName());
		employee1.setName("My New updated Name "+(new Random()).nextInt(100));
		System.out.println(employee1.getName());
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Employee employee2=(Employee) session2.get(Employee.class, 4);
		System.out.println(employee2.getName());
		//session2.update(employee1);
		session2.getTransaction().commit();
		session2.close();
		
		Session session3 = sessionFactory.openSession();
		session3.beginTransaction();
		Employee employee3=(Employee) session3.get(Employee.class, 9);
		session3.getTransaction().commit();
		session3.close();
		System.out.println(employee3.getId());
		System.out.println(employee3.getName());
		employee3.setName("My New updated Name "+(new Random()).nextInt(100));
		System.out.println(employee3.getName());
		
		Session session4 = sessionFactory.openSession();
		session4.beginTransaction();
		Employee employee4=(Employee) session4.get(Employee.class,9);
		System.out.println(employee4.getName());
		Employee employee5=(Employee) session4.merge(employee3);
		System.out.println(employee5.getName());
		System.out.println(employee3==employee5);
		session4.getTransaction().commit();
		session4.close();
		
		
	}

}
