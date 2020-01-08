package com.springdemo.one;

import org.springframework.context.annotation.Lazy;

public class BaseBallCoach  implements Coach{

	//private field for dependencies
	private FortuneService fortuneService;
	
	public BaseBallCoach() {
		
	}
	
	//define constructor for dependency injection i.e constructor injection
	public BaseBallCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
		return "spend some time working";
	}

	@Override
	public String getDailyFortune() {
		return  fortuneService.getFortune();
	}
	
}
