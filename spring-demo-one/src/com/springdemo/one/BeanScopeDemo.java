package com.springdemo.one;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) {
         //load the config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
		//retrieve the bean
		Coach coach = context.getBean("myCoach",Coach.class);
		Coach coach1 = context.getBean("myCoach",Coach.class);
		//call the method
		
		boolean isPointingToSame = (coach==coach1);
		System.out.println("Pointing to same object ? " + isPointingToSame);
		System.out.println("Memory one " + coach );
		System.out.println("Memory two " + coach1);
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getDailyWorkOut());
		//close the context
		context.close();
	}

}
