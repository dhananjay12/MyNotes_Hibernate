package com.hibernate.test;

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
		Employee aEmployee = new Employee();
		aEmployee.setName("First User");
		
		Address address1=new Address();
		address1.setStreet("Street1");
		address1.setState("State1");
		address1.setCity("City1");
		address1.setPincode("123456");
		
		Address address2=new Address();
		address2.setStreet("Street2");
		address2.setState("State2");
		address2.setCity("City2");
		address2.setPincode("654321");
		
		aEmployee.getListOfAddress().add(address1);
		aEmployee.getListOfAddress().add(address2);
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		System.out.println("session factory created");
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(aEmployee);
			session.getTransaction().commit();
			session.close();
			
			session = sessionFactory.openSession();
			Employee bEmployee = new Employee();
			bEmployee=(Employee) session.get(Employee.class,1);		
			System.out.println("Name=>"+bEmployee.getName());
			session.close();
			System.out.println("SIZE=>"+bEmployee.getListOfAddress().size());
	}

}
