package com.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "App Started!" );
        
        
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        System.out.println(sessionFactory);
        System.out.println(sessionFactory.isOpen());
        System.out.println(sessionFactory.isClosed());
        
        
        //CREATING OBJECT OF STUDENT
        Student  student=new Student();
        Student  student1=new Student();
        Student  student2=new Student();
        
        student.setId(101);
        student.setName("SOHAIL SHAIKH");
        student.setEmail("sohailss4444@gmail.com");
        student.setCity("MUMBAI");
        
        
        student1.setId(102);
        student1.setName("Viral Surti");
        student1.setEmail("Viral@gmail.com");
        student1.setCity("MUMBAI");
        
        
        student2.setId(103);
        student2.setName("Kedar Sir");
        student2.setEmail("KedarSir@gmail.com");
        student2.setCity("MUMBAI");
        
        
        //CREATING OBJECT OF ADDRESS
        
        Address add=new Address();
        
        add.setStreet("Jogeshwari");
        add.setCity("Mumbai");
        add.setCountry("INDIA");
        add.setX(true);
        add.setAddedDate(new Date());
        
        //INSERTING IMAGES INTO DATABSES
        //FOR THAT WE HAVE TO READ THE PATH  THEN STORE INTO THE DATABASE
        
        FileInputStream fis=new FileInputStream("src/main/java/Sohail_Dp.jpg");
        
        byte[] data=new byte[fis.available()];
        fis.read(data);
        add.setImage(data);
        
        
        Session session=sessionFactory.openSession();       
        Transaction transaction=session.beginTransaction();
        
        //session.save(student);
        //session.save(student1);
        // session.save(student2);
                
        //session.save(add);
        
        transaction.commit();
        sessionFactory.close();
        session.close();
        
        System.out.println("DONE !!!");
        
        
        
    }
}
