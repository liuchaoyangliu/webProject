package com.zut.lcy.dao;

import java.util.List;

import com.zut.lcy.entity.Car;

public interface CarDao {

	int addCar(Car car);

	int deleteCar(int id);

	int updateCar(Car car);

	String searchCarName(int id);

	Car searchCar(int id);

	List<Car> findAll();

}
