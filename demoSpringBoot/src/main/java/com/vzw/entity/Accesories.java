package com.vzw.entity;

import javax.persistence.Column;

public class Accesories {
	
	private int accesoryId;
	
	private String accesoryName;
	
	public Accesories(int accesoryId, String accesoryName) {
		super();
		this.accesoryId = accesoryId;
		this.accesoryName = accesoryName;
	}
	public int getAccesoryId() {
		return accesoryId;
	}
	public void setAccesoryId(int accesoryId) {
		this.accesoryId = accesoryId;
	}
	public String getAccesoryName() {
		return accesoryName;
	}
	public void setAccesoryName(String accesoryName) {
		this.accesoryName = accesoryName;
	}
	
	

}
