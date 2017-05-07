package com.mynotes.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class MySqlLauncher {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate-mysql.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("########## USING NATIVE SQL ###########");
		Query query = session.getNamedQuery("findActiveCustomer");
		List<Customer> list1 = query.list();

		list1.forEach((cust) -> System.out.println(cust));

		
		System.out.println("########## USING CRITERIA ###########");
		Criteria cr1 = session.createCriteria(Customer.class);
		List<Customer> list2 = cr1.add(Restrictions.eq("active", false)).list();
		list2.forEach((cust) -> System.out.println(cust));
		

		session.getTransaction().commit();
		session.close();

	}
}
