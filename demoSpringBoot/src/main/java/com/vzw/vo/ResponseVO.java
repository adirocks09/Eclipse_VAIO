package com.vzw.vo;

public class ResponseVO {
	
	private String petName;
	private int oldAge;
	private double increasedSalary;
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public int getOldAge() {
		return oldAge;
	}
	public void setOldAge(int oldAge) {
		this.oldAge = oldAge;
	}
	public double getIncreasedSalary() {
		return increasedSalary;
	}
	public void setIncreasedSalary(double increasedSalary) {
		this.increasedSalary = increasedSalary;
	}
	@Override
	public String toString() {
		return "ResponseVO [petName=" + petName + ", oldAge=" + oldAge + ", increasedSalary=" + increasedSalary + "]";
	}
	
}
