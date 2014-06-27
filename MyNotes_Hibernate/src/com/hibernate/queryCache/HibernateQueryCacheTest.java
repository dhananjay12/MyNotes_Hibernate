package com.hibernate.queryCache;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.hql.Employee;

public class HibernateQueryCacheTest {

	public static void main(String[] args) {
				
		SessionFactory sessionFactory = new Configuration().configure(
				"/com/hibernate/queryCache/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Query query1=session1.createQuery("from Employee where id=4");
		query1.setCacheable(true);
		List<Employee> list1=query1.list();
		session1.getTransaction().commit();
		session1.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Query query2=session2.createQuery("from Employee where id=4");
		query2.setCacheable(true);
		List<Employee> list2=query2.list();
		session2.getTransaction().commit();
		session2.close();
	}

}
