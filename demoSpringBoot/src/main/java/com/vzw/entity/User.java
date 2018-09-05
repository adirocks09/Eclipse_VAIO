package com.vzw.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	public User() {  // Default Constructor is mandatory for entity object
		super();
	}
	
	@Id
	@Column(name="U_ID")
	private int userId;
	
	@Column(name="U_NAME")
	private String userName;
	
	@Column(name="Age")
	private int age;
	
	//@Transient
	@OneToOne
	private Aadhar aadhar;
	
	//@OneToMany
	//@OneToMany(mappedBy="user" , fetch=FetchType.LAZY) //By Default the Collection is Lazy only
	@OneToMany(mappedBy="user" , fetch=FetchType.EAGER)
	//@ElementCollection
	private List<Bike> bikeList;
	
	@ManyToMany
	private List<Car> carList;
	
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Aadhar getAadhar() {
		return aadhar;
	}

	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}

	public List<Bike> getBikeList() {
		return bikeList;
	}

	public void setBikeList(List<Bike> bikeList) {
		this.bikeList = bikeList;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}


}
