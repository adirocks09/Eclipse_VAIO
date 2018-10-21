package com.vzw.vo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Faculty {

	private String facultyId;
	private String facultyName;
	private String designation;
	private String age;
	private String salary;

	public String getFacultyId() {
		return facultyId;
	}

	@XmlAttribute
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	@XmlElement
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getDesignation() {
		return designation;
	}

	@XmlElement
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAge() {
		return age;
	}

	@XmlElement
	public void setAge(String age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}
	@XmlElement
	public void setSalary(String salary) {
		this.salary = salary;
	}

}
