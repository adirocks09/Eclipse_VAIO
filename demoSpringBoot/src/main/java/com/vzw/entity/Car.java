package com.vzw.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Car")
public class Car {
	
	public Car() { // Default Constructor is mandatory for entity object
		super();
	}
	
	@Id
	@Column(name="CAR_ID")
	private int carId;
	
	
	@Column(name="CAR_NAME")
	private String carName;
	

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}


}
