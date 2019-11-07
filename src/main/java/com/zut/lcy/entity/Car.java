package com.zut.lcy.entity;

public class Car {

	private int id;
	
	private String brand;
	
	private String colour;
	
	private double displacement ;

	public Car() {
		super();
	}

	public Car(String brand, String colour, double displacement) {
		super();
		this.brand = brand;
		this.colour = colour;
		this.displacement = displacement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public double getDisplacement() {
		return displacement;
	}

	public void setDisplacement(double displacement) {
		this.displacement = displacement;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", colour=" + colour + ", displacement=" + displacement + "]";
	}

}
