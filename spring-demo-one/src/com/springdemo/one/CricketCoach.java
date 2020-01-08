package com.springdemo.one;


//to illustrate the setter injection
public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	//adding fields 
	private String emailAddress;
	private String team;
	
	
	public CricketCoach() {
		 System.out.println("CricketCoach : inside no-arg constructor");
	 }
	//setter method for setter injection
	//in xml file name = "fortuneService " so we need to use setFortuneService here.
	 public void setFortuneService(FortuneService fortuneService) {
		 System.out.println("CricketCoach : inside setter setFortuneService ");

		this.fortuneService = fortuneService;
	}

	 
		public void setEmailAddress(String email) {
		System.out.println("CricketCoach : inside setter setEmailAddress ");

			this.emailAddress = email;
		}
		public String getEmailAddress() {
			return emailAddress;
		}
		
		public void setTeam(String team) {
			
			System.out.println("CricketCoach : inside setter setTeam ");
			this.team = team;
		}
		public String getTeam() {
			return team;
		}
		
		public FortuneService getFortuneService() {
			return fortuneService;
		}
	
	@Override
	public String getDailyWorkOut() {
		return "practice bowling all the day ";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
