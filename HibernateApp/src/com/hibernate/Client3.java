package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client3 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		int id = 8;
		Employee employee = session.get(Employee.class, id);
		
		if(employee != null) {
			System.out.println("Employee found:" +employee.getName()+", Salary :" +employee.getSalary());
		}else {
			System.out.println("Employee not found with " +employee.getId() +"id");
		}
		
		transaction.commit();
		session.close();
	}
}
