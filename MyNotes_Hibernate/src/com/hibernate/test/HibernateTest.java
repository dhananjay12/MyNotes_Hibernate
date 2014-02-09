package com.hibernate.test;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.Address;
import com.hibernate.dto.Employee;

public class HibernateTest {
	static SessionFactory sessionFactory;
	static Session session;

	public static void main(String[] args) {
		System.out.println("HibernateTest");
		Employee user = new Employee();
		user.setName("First User");
		user.setDob(new Date(90, 03, 01)); //year 90 (+1900)
		user.setMobile("1234567890");
		Address addressPermanent=new Address();
		addressPermanent.setStreet("Street1");
		addressPermanent.setState("State1");
		addressPermanent.setCity("City1");
		addressPermanent.setPincode("123456");
		
		Address addressPresent=new Address();
		addressPresent.setStreet("Street2");
		addressPresent.setState("State2");
		addressPresent.setCity("City2");
		addressPresent.setPincode("654321");
		user.setPermanentAddress(addressPermanent);
		user.setPresentAddress(addressPresent);
		sessionFactory = new Configuration().configure().buildSessionFactory();
		System.out.println("session factory created");
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception occeured::" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.clear();
				session.close();
				System.out.println("All close");
			}
		}
		System.out.println("Hibernate test ended");
	}

}
