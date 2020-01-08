package com.springdemo.one;

public class MyApp {

	public static void main(String[] args) {

		Coach baseBallCoach = new BaseBallCoach();
		String working = baseBallCoach.getDailyWorkOut();
		
		System.out.println("Message is " + working);
	}

}
