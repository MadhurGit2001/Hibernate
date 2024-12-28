package com.tut.HibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmClass {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Student s1 = new Student();
		s1.setName("Shreyash");
		s1.setStudentId(03);
		s1.setAddress("E-126 Sector 20 Noida");
		s1.setRollNo(19);
		Certificate c1 = new Certificate();
		c1.setCourse("Android");
		c1.setDuration("2 month");
		s1.setCertificate(c1);

		Student s2 = new Student();
		s2.setRollNo(123);
		s2.setName("Mohan");
		s2.setAddress("Mohan nagar Ghaziabad");
		s2.setStudentId(23);
		Certificate c2 = new Certificate();
		c2.setCourse("Python");
		c2.setDuration("3 Months");
		s2.setCertificate(c2);

		Session s = sessionFactory.openSession();
		org.hibernate.Transaction tx = s.beginTransaction();
		s.save(s1);
		s.save(s2);
		tx.commit();
		s.close();
		sessionFactory.close();

	}
}
