package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		//First Object
		// CREATING A OBJECT OF STUDENT CLASS AND SETTING THE VALUES MANUALLY
		Student student = new Student();
		student.setId(104);
		student.setName("SABIYA ZEHRA");
		student.setCity("MUMBAI");
		student.setEmail("SabiyaZehra@gmail.com");

		// CREATING A OBJECT OF CERTIFICATE CLASS AND SETTING THE VALUES MANUALLY
		Certificate certificate = new Certificate();
		certificate.setCourse("ANGULAR JS");
		certificate.setDuration("2 Month");
		certificate.setFees("5000");
		student.setCertificate(certificate);

		// second object
		// CREATING A OBJECT OF STUDENT CLASS AND SETTING THE VALUES MANUALLY
		Student student1 = new Student();
		student1.setId(105);
		student1.setName("DEMO");
		student1.setCity("MUMBAI");
		student1.setEmail("DEMO@gmail.com");

		// CREATING A OBJECT OF CERTIFICATE CLASS AND SETTING THE VALUES MANUALLY
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("REACT JS");
		certificate1.setDuration("2 Month");
		certificate1.setFees("10000");
		student1.setCertificate(certificate1);

		
		//we need to add this object in the databases physically
		//so to  do that we need to create a transaction object and commit our data.
		
		Transaction tx=session.beginTransaction();
		
		//save objects
		session.save(student);
		session.save(student1);
				
		tx.commit();
		session.close();
		sessionFactory.close();
	}

}
