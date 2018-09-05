package com.vzw.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AADHAR")
public class Aadhar {
	
	public Aadhar() { // Default Constructor is mandatory for entity object
		super();
	}
	
	@Id
	@Column(name="AADHAR_ID")
	private int aadharId;
	
	
	@Column(name="DOB")
	//@Temporal(TemporalType.DATE) //only be used with java.util.Date
	private String dateOfBirth;
	
	@Column(name="CITY")
	private String city;

	public int getAadharId() {
		return aadharId;
	}

	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
