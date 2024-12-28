package com.tut.Hibernate.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Mapping {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Question question = new Question();
		question.setQuestionId(01);
		question.setQuestion("What is Hibernate");
		Answer answer = new Answer();
		answer.setAnswerId(02);
		answer.setAnswer("Hibernate is a ORM tool");
		// question.setAnswer(answer); -- for one to one mapping
		answer.setQuestion(question);

		Answer answer2 = new Answer();
		answer2.setAnswerId(03);
		answer2.setAnswer("Hibernate is essential for the spring");
		answer2.setQuestion(question);

		List<Answer> answers = new ArrayList<Answer>();
		answers.add(answer);
		answers.add(answer2);
		question.setAnswers(answers);

//		for one to one mapping 
//		Question question2 = new Question();
//		question2.setQuestionId(03);
//		question2.setQuestion("What is Embeddable");
//		Answer answer2 = new Answer();
//		answer2.setAnswerId(04);
//		answer2.setAnswer("It is annotation in hibenrate");
//		question2.setAnswer(answer2);

		Session session = factory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();

		session.save(question);
		// session.save(question2); -- for one to one mapping
		session.save(answer);
		session.save(answer2);

		transaction.commit();
		session.close();
		factory.close();

	}
}
