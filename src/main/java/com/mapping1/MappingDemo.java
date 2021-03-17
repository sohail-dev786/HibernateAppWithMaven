package com.mapping1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {

	Configuration conf=new Configuration();
	conf.configure("hibernate.cfg.xml");
	
	SessionFactory factory=conf.buildSessionFactory();
	
//	CREATING A OBJECT OF EMPLOYEE
	
	Employee emp1=new Employee();
	Employee emp2=new Employee();
	
	
	emp1.setEmpId(1001);
	emp1.setName("SOHAIL SHAIKH");
	
	emp2.setEmpId(1002);
	emp2.setName("NIKIT GHOSH");
	
	
	
//	CREATING OBJECT OF PEOJECT
	
	Project proj1=new Project();
	Project proj2=new Project();
	
	proj1.setProjId(2001);
	proj1.setProjName("CHAT BOT");
	
	proj2.setProjId(2002);
	proj2.setProjName("E-COMMERCE");
	
	//MANY TO MANY RELATION SHIP IS THERE -FOR THAT WE HAVE MULTIPLE RECORD FOR A SINGLE PERSON 
	//SO WE CAN  STORE  THAT VALES IN A LIST AND THEN ASSIGN TO OUR SETTER.
	
	List<Employee> employees=new ArrayList<Employee>();
	employees.add(emp1);
	employees.add(emp2);
	
	List<Project> projects=new ArrayList<Project>();
	projects.add(proj1);
	projects.add(proj2);
	
	
	//SETTING THIS VALUES TO EMPLOYESS AND PROJECT 
	
	emp1.setProject(projects);
	proj1.setEmployee(employees);
	
	
	//SAVING DATA PHYSICAL IN DATABASE
	
	Session session=factory.openSession();
	
	Transaction tx=session.beginTransaction();
	
	session.save(emp1);
	session.save(emp2);
	session.save(proj1);
	session.save(proj2);
	
	tx.commit();
	session.close();
	factory.close();
	
	}

}
