package com.vzw.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class A implements Serializable{
	@Id
	@Column
	private int aid;
	
	@Column
	private String aname;
	
	@ElementCollection
	private List<B> bList;

	public A() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return aid;
	}

	public void setId(int id) {
		this.aid = id;
	}

	public String getName() {
		return aname;
	}

	public void setName(String name) {
		this.aname = name;
	}

	public List<B> getbList() {
		return bList;
	}

	public void setbList(List<B> bList) {
		this.bList = bList;
	}
	
	

}
