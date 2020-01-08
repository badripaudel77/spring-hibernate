package com.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemo {

	public static void main(String[] args) {
 
		String configFile = "annotationsContext.xml";
		
		//read config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configFile);

		//retrieve bean
		Coach coach = context.getBean("theTennisCoach",Coach.class); 
		
		System.out.println(Coach.class.getName()); //just to see what's happening behind the scene
		//write some method code operations
		System.out.println(coach.getDailyWorkOut());
		
		//close the context
		context.close();
		
	}
}
