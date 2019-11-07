package com.zut.lcy._test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zut.lcy.entity.Car;

public class MybatisTest {

	SqlSession session = null;
	
	@Before
	public void bdfore() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(inputStream);
		session = factory.openSession();
	}
	
	@Test
	public void select() {
		Car car = session.selectOne("com.zut.lcy.mapper.carMapper.selectCarById", 1);
		System.out.println(car.toString());
		System.out.println("hello world!");
	}
	
	@Test
	public void update() {
		Car car = new Car("红旗", "红色", 99999);
		car.setId(8);
		session.update("com.zut.lcy.mapper.carMapper.updateCar", car);
		session.commit();
	}
	
	@Test
	public void delete() {
		session.delete("com.zut.lcy.mapper.carMapper.deleteCar", 2);
		session.commit();
	}
	
	@Test
	public void insert() {
		Car car2 = new Car("法拉利", "蓝色" , 20000);
		int i = session.insert("com.zut.lcy.mapper.carMapper.addCar", car2);
		session.commit();
	}

	@After
	public void after() {
		session.close();
	}
	
}
