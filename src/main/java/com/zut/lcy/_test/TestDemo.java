package com.zut.lcy._test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zut.lcy.server.ConferenceService;

public class TestDemo {
	
	public static void main(String[] args) {
				
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("application.xml");
//		ConferenceService conferenceService =                  
//				(ConferenceService)applicationContext.getBean("conferenceService");
//		conferenceService.conference();
//		System.out.println("\n\n");
		
		ConferenceService conferenceService = 
				(ConferenceService)applicationContext.getBean("conferenceServiceImplProxy");
		conferenceService.conference();
		
		System.out.println("hello world!");
	}
	
}
