package com.vzw.vo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="course")
public class Course {
	
	private String courseId;
	private String courseName;
	
	public String getCourseId() {
		return courseId;
	}
	
	@XmlAttribute
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	
	@XmlValue
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
}
