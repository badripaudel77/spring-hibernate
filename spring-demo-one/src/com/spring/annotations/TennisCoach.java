package com.spring.annotations;

import org.springframework.stereotype.Component;

import com.spring.annotations.Coach;

//add Component to java class

@Component("theTennisCoach") 
//spring will automatically register this bean

public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkOut() {
		
		return "Daily workOut : \"work\" hard";
	}

}
