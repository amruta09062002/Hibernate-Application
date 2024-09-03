package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Client6 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "from Employee where id >= 5";
		Query<Employee> query = session.createQuery(hql,Employee.class);
		
		List<Employee> emp = query.list();
		for (Employee empl : emp) {
			System.out.println("Id: "+empl.getId()+ ", Name: "+empl.getName()+", Salary :"+empl.getSalary());
		}
		
		transaction.commit();
		session.close();
	}
}
