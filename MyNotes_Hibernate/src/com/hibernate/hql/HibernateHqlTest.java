package com.hibernate.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHqlTest {

	public static void main(String[] args) {
				
		SessionFactory sessionFactory = new Configuration().configure(
				"/com/hibernate/hql/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query1=session.createQuery("from Employee");
		List<Employee> list1=query1.list();
		System.out.println("list1 size="+list1.size());
		
		Query query2=session.createQuery("from Employee where id>6");
		List<Employee> list2=query2.list();
		System.out.println("list2 size="+list2.size());
		
		Query query3=session.createQuery("from Employee where id > ?");
		query3.setInteger(0, 6);
		List<Employee> list3=query3.list();
		System.out.println("list3 size="+list3.size());
		
		Query query4=session.createQuery("from Employee where id > :myId");
		query4.setInteger("myId", 6);
		List<Employee> list4=query4.list();
		System.out.println("list4 size="+list4.size());
		
		
		Query query5=session.createQuery("from Employee");
		query5.setFirstResult(3);
		query5.setMaxResults(4);
		List<Employee> list5=query5.list();
		System.out.println("list5 size="+list5.size());
		for (Employee employee : list5) {
			System.out.println(employee.getName());
		}
		
		Query query6=session.createQuery("update Employee set name = :newName" +
				" where id = :myId");
		query6.setInteger("myId", 6);
		query6.setString("newName", "New Employee Name");
		int result = query6.executeUpdate();
		System.out.println("result="+result);
		
	
		session.getTransaction().commit();
		session.close();
	}

}
