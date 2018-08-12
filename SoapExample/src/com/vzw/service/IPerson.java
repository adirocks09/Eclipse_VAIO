package com.vzw.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.vzw.beans.Person;
@WebService
@SOAPBinding  
public interface IPerson {
	
	@WebMethod
	public boolean addPerson(Person p);
	@WebMethod
	public boolean deletePerson(int id);
	@WebMethod
	public Person getPerson(int id);
	@WebMethod
	public Person[] getAllPersons();
	

}
