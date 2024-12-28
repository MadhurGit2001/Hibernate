package com.tut.Hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyMapping {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Employee e1 = new Employee();
		e1.setEmployeeId(1);
		e1.setName("Arjun");

		Employee e2 = new Employee();
		e2.setEmployeeId(2);
		e2.setName("Rohit");

		Project p1 = new Project();
		p1.setProjectId(3);
		p1.setProjectName("Larsen Turbo");

		Project p2 = new Project();
		p2.setProjectId(4);
		p2.setProjectName("Boat Nirvana");

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		List<Project> projects = new ArrayList<Project>();
		projects.add(p1);
		projects.add(p2);

		e1.setProjects(projects);
		p2.setEmployees(employees);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);

		transaction.commit();
		session.close();
		factory.close();

	}
}
