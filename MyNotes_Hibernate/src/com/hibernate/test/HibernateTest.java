package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.Employee;

public class HibernateTest {
	
	public static void main(String[] args) {
		System.out.println("HibernateTest");
		Employee user=new Employee();
		user.setId(1);
		user.setName("First User");
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		System.out.println("session factory created");
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}


}
