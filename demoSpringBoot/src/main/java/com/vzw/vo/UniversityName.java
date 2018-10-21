package com.vzw.vo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="universityName")
public class UniversityName {

	private String universityId;
	private String universityName;

	public String getUniversityId() {
		return universityId;
	}

	@XmlAttribute
	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	@XmlValue
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
	
}
