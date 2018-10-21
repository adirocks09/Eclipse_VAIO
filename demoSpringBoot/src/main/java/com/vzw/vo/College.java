package com.vzw.vo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class College {

	private String collegeId;
	private String collegeName;
	private String studentsCount;
	private String dean;
	public String getCollegeId() {
		return collegeId;
	}
	
	@XmlAttribute
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	
	public String getCollegeName() {
		return collegeName;
	}
	
	@XmlElement
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	public String getStudentsCount() {
		return studentsCount;
	}
	
	@XmlElement
	public void setStudentsCount(String studentsCount) {
		this.studentsCount = studentsCount;
	}
	
	public String getDean() {
		return dean;
	}
	
	@XmlElement(name="dean")
	public void setDean(String dean) {
		this.dean = dean;
	}
}
