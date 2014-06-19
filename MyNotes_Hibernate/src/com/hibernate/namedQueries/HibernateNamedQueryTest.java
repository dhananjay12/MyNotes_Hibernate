package com.hibernate.namedQueries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateNamedQueryTest {

	public static void main(String[] args) {
				
		SessionFactory sessionFactory = new Configuration().configure(
				"/com/hibernate/namedQueries/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query1=session.getNamedQuery("findEmployeeById");
		query1.setInteger("passId", 2);
		List<Employee> list1=query1.list();
		System.out.println("Name=>"+list1.get(0).getName());
		
		Query query2=session.getNamedQuery("findEmployeeByIdNativeSQL");
		query2.setInteger("passId", 2);
		List<Employee> list2=query2.list();
		System.out.println("Name=>"+list2.get(0).getName());
		
		Query query3=session.getNamedQuery("findEmployeeByIdStoreProcedure")
					 .setInteger("passId", 2);
		List<Employee> list3=query3.list();
		System.out.println("Name=>"+list3.get(0).getName());
		

		Query query4 = session.createSQLQuery(
				"CALL GET_EMPLOYEE_BY_ID(:passId)")
				.addEntity(Employee.class)
				.setParameter("passId", "5");
		List<Employee> list4=query4.list();
		System.out.println("Name=>"+list4.get(0).getName());
	
		session.getTransaction().commit();
		session.close();
	}

}
