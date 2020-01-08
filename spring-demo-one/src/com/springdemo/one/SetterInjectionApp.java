package com.springdemo.one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionApp {

	public static void main(String[] args) {

		//load the configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean from the file
		CricketCoach theCricketCoach = (CricketCoach) context.getBean("myCricketCoach",Coach.class);
		//call on the methods
		System.out.println("Message form cricket coach : "+ theCricketCoach.getDailyWorkOut()+ " \nand wish is : " +theCricketCoach.getDailyFortune());
		
		//printing literal values 
		System.out.println("email is : " + theCricketCoach.getEmailAddress());
		System.out.println("the team is "+ theCricketCoach.getTeam());
		
		//close the context
		context.close();
	}

}
