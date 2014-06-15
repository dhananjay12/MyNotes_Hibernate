package com.hibernate.one2many.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateOne2ManyTest {
	static SessionFactory sessionFactory;
	static Session session;

	public static void main(String[] args) {
		
		Employee aEmployee = new Employee();
		aEmployee.setName("Employee Name1");
		
		Address address1=new Address();
		address1.setStreet("Street1");
		address1.setCity("City1");
		address1.setEmployee(aEmployee);
				
		Address address2=new Address();
		address2.setStreet("Street2");
		address2.setCity("City2");
		address2.setEmployee(aEmployee);
		
		aEmployee.getAddress().add(address1);
		aEmployee.getAddress().add(address2);
		
		sessionFactory = new Configuration().configure("/com/hibernate/one2many/mapping/hibernate.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(aEmployee);
			session.save(address1);
			session.save(address2);
			session.getTransaction().commit();
			session.close();
			
		}

}
