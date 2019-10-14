package com.zut.lcy._test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zut.lcy.entity.Boss;
import com.zut.lcy.entity.Car;
import com.zut.lcy.entity.Conference;
import com.zut.lcy.server.ConferenceService;

public class TestDemo {
	
	public static void main(String[] args) {
				
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("application.xml");
		
//		Car car = (Car)applicationContext.getBean("car");
//		
//		System.out.println(car.toString());		
//		
//		Boss boss = (Boss)applicationContext.getBean("boss");
//		
//		System.out.println(boss.toString());
		
		ConferenceService conferenceService = (ConferenceService)applicationContext.getBean("conferenceService");

		conferenceService.conference();
		
		System.out.println("hello world!");
		
	}
	
}
