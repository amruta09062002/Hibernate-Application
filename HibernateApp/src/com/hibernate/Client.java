package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {
	
	public static void main(String[] args) {
		System.out.println("step-1");
		Configuration cfg = new Configuration();
		cfg.configure();
		
		System.out.println("step-2");
		cfg.addAnnotatedClass(Employee.class);
		
		System.out.println("step-3");
		SessionFactory factory = cfg.buildSessionFactory();
		
		System.out.println("step-4");
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setId(8);
		employee.setName("Amruta");
		employee.setSalary(35000);
		
		session.save(employee);
		transaction.commit();
		
		System.out.println("Employee inserted successfully");
		session.close();
	}
}
