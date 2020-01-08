package com.hibernate.demo.main;

import org.hibernate.Session;

//import from hibernate to create session
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.demo.entity.Customer;


public class HibernateDemo{

	public static void main(String[] args) {

		//create session factory new Configuration.CAB(lowercase starting as they are method SERIALLY
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create customer obj
			System.out.println("Creating customer object");
			Customer customer1 = new Customer("Badri Paudel","badri@gmail.com");
			Customer customer2 = new Customer("Sujan Paudel","sujan111@gmail.com");
			Customer customer3 = new Customer("Hari Upadhyay","_hari@gmail.com");

			//start the transaction
            System.out.println("starting transaction");
			session.beginTransaction();
			
			//saving the object
			System.out.println("saving the objects...");
			session.save(customer1);
			session.save(customer2);
			session.save(customer3);
			
			//commit the transaction
			System.out.println("commiting the transaction --done");
			session.getTransaction().commit();
			//retrieving from the database
			
			//now get the new session and begin transaction
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			
			//getting primary key
			System.out.println("The customer with id ..." + customer1.getId());
			
			//retrieve the customer based on Id in the database
			Customer customers = session.get(Customer.class, customer1.getId());
			
			//printing value
			System.out.println("printing the customer based on id " + customer1.getId());
  			System.out.println(" " + customers);
  			
  			//commit transaction
  			System.out.println("commiting again ");
  			session.getTransaction().commit();
  			System.out.println("done ===================");
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
