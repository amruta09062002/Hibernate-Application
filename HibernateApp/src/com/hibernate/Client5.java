package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Client5 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "Select MAX(salary) from Employee";
		Query<Double> query = session.createQuery(hql, Double.class);
		Double maxSalary = query.uniqueResult();

		if (maxSalary != null) {
			System.out.println("Maximun salary is " + maxSalary);
		} else {
			System.out.println("No employees found in the database");
		}

		transaction.commit();
		session.close();
	}
}
