package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		// Creating Question 1
		Question question = new Question();
		question.setQuestionId(101);
		question.setQuestion("WHAT IS JAVA ?");

		// Creating Answer 1
		Answer answer = new Answer();
		answer.setAnswerId(201);
		answer.setAnswer("JAVA IS HIGH LEVEL PROGRMAMMING LANGUAGE");
		question.setAnswer(answer);

		// Creating Question 2
		Question question1 = new Question();
		question1.setQuestionId(102);
		question1.setQuestion("WHAT IS SQL?");

		// Creating Answer 2
		Answer answer1 = new Answer();
		answer1.setAnswerId(202);
		answer1.setAnswer("STRUCTURE QUERY LANGUAGE");
		question1.setAnswer(answer1);

		// Creating a Session
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(question);
		session.save(question1);
		session.save(answer);
		session.save(answer1);
				
		//FETCHING  DATA....
		Question fetchQuestion=(Question)session.get(Question.class, 101);
		
		System.out.println("-------------------");
		
		System.out.println(fetchQuestion.getQuestion());
		System.out.println(fetchQuestion.getAnswer().getAnswer());
		
		System.out.println("-------------------");
		
		Question fetchQuestion1=(Question)session.get(Question.class, 102);
		System.out.println(fetchQuestion1.getQuestion());
		System.out.println(fetchQuestion1.getAnswer().getAnswer());
		
		System.out.println("-------------------");
		
		
		tx.commit();

		session.close();
		factory.close();

	}

}
