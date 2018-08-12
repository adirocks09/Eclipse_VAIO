package com.vzw.vo;

import org.springframework.beans.factory.annotation.Autowired;

public class SampleBean {
	
	@Autowired
	private SampleBean2 sp;

	private String name;
	private int age;
	private double marks;
	
	public SampleBean(String name, int age, double marks) {
		super();
		this.name = name;
		this.age = age;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public SampleBean2 getSp() {
		return sp;
	}

	public void setSp(SampleBean2 sp) {
		this.sp = sp;
	}

	@Override
	public String toString() {
		return "SampleBean [name=" + name + ", age=" + age + ", marks=" + marks + "]";
	}
}
