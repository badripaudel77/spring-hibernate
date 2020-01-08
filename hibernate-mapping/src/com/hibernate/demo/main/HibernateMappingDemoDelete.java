package com.hibernate.demo.main;

import org.hibernate.Session;
//import from hibernate to create session
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;


public class HibernateMappingDemoDelete{

	public static void main(String[] args) {

		//create session factory new Configuration.CAB(lowercase starting as they are method SERIALLY
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {

			//start the transaction
            System.out.println("starting transaction");
			session.beginTransaction();
			
			//getting the instructor based on Id
		    int instructorId =3;
			
		   Instructor instructor = session.get(Instructor.class, instructorId);
	
		   System.out.println("instructor -- " + instructor );
		   //delete the instructor
		    if(instructor!=null) {
		    	
		    	System.out.println("deleting insructor " + instructorId);
		    	session.delete(instructor);
		    }
		    else {
		    	System.out.println("Requested ID doesn't exist. ID is " + instructorId);
		    }
		   //commit the transaction
			System.out.println("commiting the transaction --done");
			session.getTransaction().commit();
	
  			System.out.println("done ===================");
		}
		catch(Exception e) {
			System.out.println(" OOPS ! something went wrong ");
			e.printStackTrace();
		}
		
		finally {
			//resolves the leak error 
			System.out.println("----closing the session --------");
             session.close();
			System.out.println("----- Closing factory -----");
			factory.close();
		}
	}
}
