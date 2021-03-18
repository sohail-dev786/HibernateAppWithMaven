package com.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Index;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

//		OneToOne  --> DEMO

//		Creating Question 1

//		Question question = new Question();
//		question.setQuestionId(101);
//		question.setQuestion("WHAT IS JAVA ?");

//		 Creating Answer 1

//		Answer answer = new Answer();
//		answer.setAnswerId(201);
//		answer.setAnswer("JAVA IS HIGH LEVEL PROGRMAMMING LANGUAGE");
//		question.setAnswer(answer);

//		Creating Question 2

//		Question question1 = new Question();
//		question1.setQuestionId(102);
//		question1.setQuestion("WHAT IS SQL?");

//		Creating Answer 2
//		Answer answer1 = new Answer();
//		answer1.setAnswerId(202);
//		answer1.setAnswer("STRUCTURE QUERY LANGUAGE");
//		question1.setAnswer(answer1);

//		OneToMany  & ManyToOne  ->Demo 

		Question question = new Question();
		question.setQuestionId(111);
		question.setQuestion("WHAT IS JAVA  ?");

		Answer answer = new Answer();
		answer.setAnswerId(222);
		answer.setAnswer("JAVA IS A HIGH LEVEL PRGRAMMING LANGUAGE");
		answer.setQuestion(question);

		Answer answer1 = new Answer();
		answer1.setAnswerId(333);
		answer1.setAnswer("JAVE HAVE DIEFFERENT TYPES OF FRAMEWORK");
		answer1.setQuestion(question);

		Answer answer2 = new Answer();
		answer2.setAnswerId(444);
		answer2.setAnswer("JAVA IS HIGLY DEMAND IN MARKET NOW A DAYS !!!");
		answer2.setQuestion(question);

		List<Answer> ansList = new ArrayList<Answer>();
		ansList.add(answer);
		ansList.add(answer1);
		ansList.add(answer2);

		question.setAnswer(ansList);

		// Creating a Session
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

//		OneToMany & ManyToOne -> Demo
//		session.save(question);
//		session.save(answer);
//		session.save(answer1);
//		session.save(answer2);

//		OneToOne ->demo
//		session.save(question);
//		session.save(question1);
//		session.save(answer);
//		session.save(answer1);
		
		
		
		

//		        FETCHING  DATA....

//		OneToMany  & ManyToOne  ->demo
		Question fetchQuestion = session.get(Question.class, 111);

		System.out.println(fetchQuestion.getQuestionId());
		System.out.println(fetchQuestion.getQuestion());
		System.out.println(fetchQuestion.getAnswer().size());

		
//		System.out.println("-------------------");

//		for (Answer a : fetchQuestion.getAnswer()) {
//			
//			System.out.println("-------------------");
//
//			System.out.println(a.getAnswer());
//
//			System.out.println("-------------------");
//
//
//		}

		
		
		

//		OneToOne ->demo
//		Question fetchQuestion=(Question)session.get(Question.class, 101);
//		
//		System.out.println("-------------------");
//		
//		System.out.println(fetchQuestion.getQuestion());
//		System.out.println(fetchQuestion.getAnswer().getAnswer());
//		
//		System.out.println("-------------------");
//		
//		Question fetchQuestion1=(Question)session.get(Question.class, 102);
//		System.out.println(fetchQuestion1.getQuestion());
//		System.out.println(fetchQuestion1.getAnswer().getAnswer());
//		
//		System.out.println("-------------------");
//		
		
		
		

		tx.commit();

		session.close();
		factory.close();

	}

}
