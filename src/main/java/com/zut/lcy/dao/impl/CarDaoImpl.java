package com.zut.lcy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.zut.lcy.dao.CarDao;
import com.zut.lcy.entity.Car;

@Component("carDao")
public class CarDaoImpl implements CarDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public CarDaoImpl() {
		super();
	}

	@Override
	public int addCar(Car car) {
		String sql = "insert into car(brand, colour, displacement) value(?, ?, ?)";
		Object[] obj = new Object[] { car.getBrand(), car.getColour(), car.getDisplacement() };
		return jdbcTemplate.update(sql, obj);
	}

	@Override
	public int deleteCar(int id) {
		String sql = "delete from `car` where `id` = ?";
		return jdbcTemplate.update(sql);
	}

	@Override
	public int updateCar(Car car) {
		String sql = "update `car` set `brand` = ?,  `colour` = ?,  `displacement` = ? where `id` = ? ;";
		Object[] obj = new Object[] { car.getBrand(), car.getColour(), car.getDisplacement(), car.getId() };
		return jdbcTemplate.update(sql, obj);
	}

	@Override
	public String searchCarName(int id) {
		String sql = "select * from car where id = ?";
		Object[] obj = new Object[] { id };
		List<Car> list = jdbcTemplate.query(sql, obj, new RowMapper<Car>() {
			@Override
			public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setBrand(rs.getString("brand"));
				car.setColour(rs.getString("colour"));
				car.setDisplacement(rs.getDouble("displacement"));
				return car;
			}
		});
		Car car = list.get(0);
		return car.getBrand();
	}

	@Override
	public Car searchCar(int id) {
		String sql = "select * from car where id = ?";
		Object[] obj = new Object[] { id };
		List<Car> list = jdbcTemplate.query(sql, obj, new RowMapper<Car>() {
			@Override
			public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setBrand(rs.getString("brand"));
				car.setColour(rs.getString("colour"));
				car.setDisplacement(rs.getDouble("displacement"));
				return car;
			}
		});
		return list.get(0);
	}

	@Override
	public List<Car> findAll() {
		String sql = "select * from car";
		List<Car> list = jdbcTemplate.query(sql, new RowMapper<Car>() {
			@Override
			public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setBrand(rs.getString("brand"));
				car.setColour(rs.getString("colour"));
				car.setDisplacement(rs.getDouble("displacement"));
				return car;
			}
		});
		return list;
	}

}
