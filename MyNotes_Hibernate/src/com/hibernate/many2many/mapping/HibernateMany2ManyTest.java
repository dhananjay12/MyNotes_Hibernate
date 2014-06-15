package com.hibernate.many2many.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMany2ManyTest {
	static SessionFactory sessionFactory;
	static Session session;

	public static void main(String[] args) {
		
		Employee aEmployee = new Employee();
		aEmployee.setName("Employee Name1");
		
		Project project1=new Project();
		project1.setProjectName("Project1");
				
		Project project2=new Project();
		project2.setProjectName("Project2");
		
		aEmployee.getProject().add(project1);
		aEmployee.getProject().add(project2);
		project1.getEmployee().add(aEmployee);
		project2.getEmployee().add(aEmployee);
				
		sessionFactory = new Configuration().configure("/com/hibernate/many2many/mapping/hibernate.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(aEmployee);
			//session.save(project1);
			//session.save(project2);
			session.getTransaction().commit();
			session.close();
			
		}

}
