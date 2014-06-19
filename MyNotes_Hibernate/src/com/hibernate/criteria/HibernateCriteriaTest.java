package com.hibernate.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HibernateCriteriaTest {

	public static void main(String[] args) {
				
		SessionFactory sessionFactory = new Configuration().configure(
				"/com/hibernate/criteria/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria cr1 = session.createCriteria(Employee.class);
		List<Employee> list1 = cr1.list();
		
		Criteria cr2 = session.createCriteria(Employee.class)
					   .add(Restrictions.lt("id", 8))
					   .add(Restrictions.gt("id", 4));
		List<Employee> list2 = cr2.list();
		
		Criteria cr3 = session.createCriteria(Employee.class)
				   .add(Restrictions.or(Restrictions.gt("id", 8),Restrictions.lt("id", 4)));
		List<Employee> list3 = cr3.list();
	
	Criteria cr4 = session.createCriteria(Employee.class)
			   .add(Restrictions.lt("id", 4))
			   .addOrder(Order.desc("id"));
		List<Employee> list4 = cr4.list();
	
		for (Employee employee : list4) {
			System.out.println(employee.getId()+" " +employee.getName());
		}
		
		Criteria cr5 = session.createCriteria(Employee.class)
						.setProjection(Projections.max("id"));
		List maxIdList=cr5.list();
		System.out.println("maxId=>"+maxIdList.get(0));
		
		
		Employee myEmployee=new Employee();
		myEmployee.setId(2);//primary key is not considered
		myEmployee.setName("Employee Name3");
		
		Example example=Example.create(myEmployee);
		Criteria cr6 = session.createCriteria(Employee.class)
					   .add(example);
		List<Employee> list6 = cr6.list();
		
		for (Employee employee : list6) {
			System.out.println(employee.getId()+" " +employee.getName());
		}
		
	
		session.getTransaction().commit();
		session.close();
	}

}
