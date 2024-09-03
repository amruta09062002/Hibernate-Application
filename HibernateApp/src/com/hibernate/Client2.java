package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client2 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setId(3);
		employee.setName("Jayesh");
		employee.setSalary(19000);
		
		session.update(employee);
		transaction.commit();
		
		System.out.println("Employee updated successfully.");
		session.close();
	}
}
