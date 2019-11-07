package com.zut.lcy._test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zut.lcy.dao.CarDao;
import com.zut.lcy.entity.Car;
import com.zut.lcy.server.CarService;

public class JDBCTemplate {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		CarService carService = (CarService)applicationContext.getBean("carService");
		
		carService.transfer(1, 2, 99);
		
		
	}
	
}
