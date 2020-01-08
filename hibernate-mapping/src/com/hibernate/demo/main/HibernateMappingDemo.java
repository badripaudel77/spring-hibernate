package com.hibernate.demo.main;

import org.hibernate.Session;
//import from hibernate to create session
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;


public class HibernateMappingDemo{

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
			
			//create  objects
			System.out.println("creating objects");
		   
			Instructor instructor = 
					new Instructor("Ganesh", "Stha", "aneshp@gmail.com");
			
			InstructorDetail instructorDetail = 
					new InstructorDetail("www.ganesh.com/youtube", "Coding");

			//associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			//start the transaction
            System.out.println("starting transaction");
			session.beginTransaction();
			
			//saving the object
			System.out.println("saving the objects...see carefully " + instructor);
			
			//this will save instructorDetail as well
			// because of the CASCADETYPE.ALL
			session.save(instructor);
			
			
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
			System.out.println("----- Closing factory -----");
			factory.close();
		}
	}
}
