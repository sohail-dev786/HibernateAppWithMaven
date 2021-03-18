package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Certificate;
import com.hibernate.Student;

public class HibernateObjectStates {

	public static void main(String[] args) {

	
		//WE ARE  USING STUDENT CLASS OVER HERE TO DEMONSTRATE THE HIBERNATE OBJECT STATES
		
//		1)TRANSIENT STATE
//		2)PERSISTENT STATE
//		3)DETACHED STATE
//		4)REMOOAVE STATE
		
		
//		CREATING A STUDENT OBJECT
		
		Student student=new Student();
		student.setId(11);
		student.setName("SOHAIL");
		student.setEmail("Sohail4444@gmail.com");
		student.setCity("MUMBAI");
		student.setCertificate(new Certificate("FUll stack", "2 Year", "85000"));
		
//		ONCE WE SET THE VALUES THE  VALUES -->OBJECT WAS IN (TRANSIENT STATE)
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=factory.openSession();
		
//		ONCE WE SAVE OUR OBJECT , STATES CHANGES TO -->PERSISTENT
//		(THAT MEANS THIS OBJECT NOW ASSOCIATED WITH BOTH -(SESSION OBJEVT AND AS WELL AS DATABASE))
		session.save(student);
		
		
		Transaction tx=session.beginTransaction();
		
		
		
		tx.commit();
		
//		ONCE SESSION OBJECT IS CLOSE THEN STATES GOES TO -DETACHED STATE
//		THAT MEANS WE CANNOT UPDATE THE VALUES ONCE SESSION IS CLOSE
		session.close();
		
		student.setName("Nikit");
		factory.close();

//		THEN OF WE WE REMOVE OR DELETE OBJECT THAT MEANS STATE CHANGES TO -REMOVE STATE
		
	}

}
