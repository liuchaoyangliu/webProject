package com.zut.lcy.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zut.lcy.dao.CarDao;
import com.zut.lcy.entity.Car;
import com.zut.lcy.server.CarService;

@Service("carService")
public class CarServiceImple implements CarService{

	@Autowired
	CarDao carDao;
	
	@Override
	@Transactional
	public void transfer(int idTo, int idFrom, double money) {
		
		Car carTo = new Car();
		carTo.setId(idTo);
		carTo.setBrand("保时捷");
		carTo.setColour("黄色");
		carTo.setDisplacement(1000 - money);
		
		Car carFrom = new Car();
		carFrom.setId(idFrom);
		carFrom.setBrand("宝马");
		carFrom.setColour("银色");
		carFrom.setDisplacement(1000 + money);
		
		carDao.updateCar(carTo);
		System.out.println("carTo已经更新");
		int i = 1 / 0;
		carDao.updateCar(carFrom);
		System.out.println("carFrom已经更新");
	}

}
