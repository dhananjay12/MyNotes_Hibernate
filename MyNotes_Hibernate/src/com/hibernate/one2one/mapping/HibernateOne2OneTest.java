package com.hibernate.one2one.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateOne2OneTest {
	static SessionFactory sessionFactory;
	static Session session;

	public static void main(String[] args) {
		System.out.println("HibernateTest");
		Employee aEmployee = new Employee();
		aEmployee.setName("Employee Name1");
		
		BankDetails aBankDetails=new BankDetails();
		aBankDetails.setBankName("Bank1");
		aBankDetails.setAccountNumber("AccountNumber123");
		
		aEmployee.setBankDetails(aBankDetails);
		
		sessionFactory = new Configuration().configure("/com/hibernate/one2one/mapping/hibernate.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(aEmployee);
			session.save(aBankDetails);
			session.getTransaction().commit();
			session.close();
			
		}

}
