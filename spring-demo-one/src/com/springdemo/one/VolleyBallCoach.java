package com.springdemo.one;

public class VolleyBallCoach implements Coach {

	//private field for dependencies
		private FortuneService fortuneService;
		
		public VolleyBallCoach() {
			
		}
		
		//define constructor for dependency injection i.e constructor injection
		public VolleyBallCoach(FortuneService theFortuneService) {
			this.fortuneService = theFortuneService;
		}
	@Override
	public String getDailyWorkOut() {
		return "Practice Daily playing volleyball";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
}
