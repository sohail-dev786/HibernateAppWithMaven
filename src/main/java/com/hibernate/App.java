package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "App Started!" );
        
        
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        System.out.println(sessionFactory);
        System.out.println(sessionFactory.isOpen());
        System.out.println(sessionFactory.isClosed());
        
        Student  student=new Student();
        
        student.setId(101);
        student.setName("SOHAIL SHAIKH");
        student.setEmail("sohailss4444@gmail.com");
        student.setCity("MUMBAI");
        
        
        Session session=sessionFactory.openSession();
        
        Transaction transaction=session.beginTransaction();
        
        session.save(student);
        
        transaction.commit();
        
        session.close();
        
        
        
        
    }
}
