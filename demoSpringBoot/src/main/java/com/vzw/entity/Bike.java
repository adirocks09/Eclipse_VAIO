package com.vzw.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BIKE")
public class Bike {
	
	public Bike() { // Default Constructor is mandatory for entity object
		super();
	}
	
	@Id
	@Column(name="BIKE_ID")
	private int bikeId;
	
	
	@Column(name="BIKE_NAME")
	private String bikeName;
	
	@ManyToOne
	private User user;

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
