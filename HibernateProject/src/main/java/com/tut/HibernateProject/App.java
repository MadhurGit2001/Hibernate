package com.tut.HibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// Build the SessionFactory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg2.xml").buildSessionFactory();

		// Create a new Student object
		Student st = new Student();
		st.setStudentId(1);
		st.setName("Madhur");
		st.setRollNo(190);
		st.setAddress("E-Block Sector 20 Noida");

		// Open a new session
		Session session = sessionFactory.openSession();

		// Start a transaction
		Transaction transaction = session.beginTransaction();

		// Save the student object
		session.save(st);

		// Commit the transaction
		transaction.commit();

		// Close the session
		session.close();

		// Close the SessionFactory
		sessionFactory.close();

		System.out.println("Student saved successfully!");
	}
}
