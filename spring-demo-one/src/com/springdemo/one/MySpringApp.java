package com.springdemo.one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {

	public static void main(String[] args) {

		// load the configuration file
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");

		// for baseball coach
		// retrieve the bean
		Coach theCoach = context.getBean("myCoach", Coach.class);

		// call the method on bean
		System.out.println(theCoach.getDailyWorkOut());

		// 2) for volleyball coach

		// retrieve the bean
		Coach theCoach1 = context.getBean("myCoach1", Coach.class);

		// call the method on bean
		System.out.println(theCoach1.getDailyWorkOut());

		// call using dependencies injection
		System.out.println(theCoach1.getDailyFortune());

		
		        //call the method on bean
				System.out.println(theCoach.getDailyWorkOut());

				// call using dependencies injection
				System.out.println(theCoach.getDailyFortune());
		
		// close the context (just to make clean up)
		context.close();

	}

}
