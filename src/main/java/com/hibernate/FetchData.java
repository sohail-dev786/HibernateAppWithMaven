package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		//Using get
		Student student=session.get(Student.class, 101);
		
		//Using load
		Student student1=session.load(Student.class, 103);
		
		System.out.println(student);
		System.out.println(student1);
				
		sessionFactory.close();
		session.close();
		
		
		
	}
	
	
}
