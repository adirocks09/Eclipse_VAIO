package com.vzw.app;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.vzw.service.IPerson;

public class MainApp {
	
	public static void main(String[] args) throws Exception {  
	    URL url = new URL("http://localhost:8080/SoapExample/services/PersonImpl?wsdl");  
	   
	     //1st argument service URI, refer to wsdl document above  
	    //2nd argument is service name, refer to wsdl document above  
	        QName qname = new QName("http://service.vzw.com", "PersonImplService");  
	        Service service = Service.create(url, qname);  
	        IPerson person = service.getPort(IPerson.class);  
	        System.out.println(person.getAllPersons());  
	     }  

}
