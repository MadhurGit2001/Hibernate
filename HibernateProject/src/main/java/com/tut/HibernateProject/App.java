package com.tut.HibernateProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		// Build the SessionFactory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Create a new Student object
		Student st = new Student();
		st.setStudentId(1);
		st.setName("Madhur");
		st.setRollNo(190);
		st.setAddress("E-Block Sector 20 Noida");

		Address address = new Address();
		address.setStreet("Laxmi nagar");
		address.setAddedDate(new Date(0));
		address.setCity("Mathura");
		address.setOpen("false");

		// Reading Image
		byte[] data = Files.readAllBytes(Paths.get("src/main/java/pic.png"));

		// Assuming address is an instance of your entity class
		address.setImage(data);

		// Open a new session
		Session session = sessionFactory.openSession();

		// Start a transaction
		Transaction transaction = session.beginTransaction();

		// Save the student object
		session.save(st);
		session.save(address);

		// Commit the transaction
		transaction.commit();

		// Close the session
		session.close();

		// Close the SessionFactory
		sessionFactory.close();

		System.out.println("Student saved successfully!");
	}
}
