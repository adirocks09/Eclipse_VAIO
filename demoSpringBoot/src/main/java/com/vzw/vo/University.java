package com.vzw.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="University")
public class University {
	
	private UniversityName universityName ;
	private String state;
	private String deemed;
	private List<Course> courses;
	private List<College> colleges;
	private List<Faculty> faculties;
	
	public UniversityName getUniversityName() {
		return universityName;
	}
	
	@XmlElement
	public void setUniversityName(UniversityName universityName) {
		this.universityName = universityName;
	}
	
	public String getState() {
		return state;
	}
	
	@XmlElement
    public void setState(String state) {
		this.state = state;
	}
	
	public String getDeemed() {
		return deemed;
	}
	
	@XmlElement
	public void setDeemed(String deemed) {
		this.deemed = deemed;
	}

	public List<Course> getCourses() {
		return courses;
	}

	@XmlElement(name="course")
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public List<College> getColleges() {
		return colleges;
	}

	@XmlElementWrapper(name="Colleges")
	@XmlElement(name="College")
	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}
	
	public List<Faculty> getFaculties() {
		return faculties;
	}
	
	@XmlElementWrapper(name="Faculties")
	@XmlElement(name="Faculty")
	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}
	
}
