package com.hibernate.inheritance.tablePerSubclassStatergy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateInheritanceTablePerSubclassStatergyTest {
	public static void main(String[] args) {
		
		ComputerDetails aComputerDetails = new ComputerDetails();
		aComputerDetails.setOperatingSystem("Windows 8.1");
		
		Desktop aDesktop=new Desktop();
		aDesktop.setOperatingSystem("Windows 7");
		aDesktop.setKeyBoardDetails("From iBall");
				
		Laptop aLaptop=new Laptop();
		aLaptop.setOperatingSystem("Ubuntu 14.04");
		aLaptop.setChargerId("QWERT123");
		
		
		SessionFactory sessionFactory = new Configuration().configure("/com/hibernate/inheritance/tablePerSubclassStatergy/hibernate.cfg.xml").buildSessionFactory();
		Session	session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(aComputerDetails);
			session.save(aDesktop);
			session.save(aLaptop);
			session.getTransaction().commit();
			session.close();
			
		}

}
