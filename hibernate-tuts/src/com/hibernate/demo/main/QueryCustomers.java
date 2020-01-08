package com.hibernate.demo.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Customer;

public class QueryCustomers {

	
	public static void main(String[] args) {

		//create session factory .CAB SERIALLY
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
		
			//start the transaction 
			System.out.println("start the transaction");
			session.beginTransaction();
	
			//retrieving the list of the customers from the database with help of POJO class
			List<Customer> theCustomers = session
					.createQuery("from Customer c where c.name='Badri Paudel'")
					.getResultList();
  			
			//displaying result..
			//System.out.println("Result is " + theCustomers);
			
			for(Customer customer : theCustomers) {
				System.out.println(customer);
			}
  			//commit transaction
  			System.out.println("commiting transaction");
  			session.getTransaction().commit();
  			
  			System.out.println("============== done ===================");
		}
		
		catch(Exception e) {
			System.out.println("error establishing the connection to the database");
			e.printStackTrace();
		}
		
		finally {
			System.out.println("----- Closing factory -----");
			factory.close();
		}
	}	
}
