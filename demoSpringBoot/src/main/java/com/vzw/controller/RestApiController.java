package com.vzw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vzw.vo.RequestVO;
import com.vzw.vo.ResponseVO;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	private RequestVO autowiredRequestVO; // Autowiring creates instance of the class
	
	private RequestVO requestVO; // Instance is not created 
	
	RequestVO objectRequestVO = new RequestVO();
	
	@RequestMapping("/hello")
	public String greet(){
		System.out.println(autowiredRequestVO.toString()); //Works FIne!!!!....because of Autowiring , An instance is created and it doesnt give null pointer exception
		System.out.println(objectRequestVO.toString());
		//System.out.println(requestVO.toString());//Gives Null Pointer Exception
		return "Hello world from Server side";
	}
	
	@RequestMapping(value = "/viewResponse", method = RequestMethod.POST)
	public @ResponseBody ResponseVO content(@RequestBody RequestVO request){
		System.out.println(request.toString());
		ResponseVO response = new ResponseVO();
		response.setPetName(request.getName().concat(" Kumar"));
		response.setOldAge(request.getAge()+3);
		response.setIncreasedSalary(request.getSalary()*2);
		return response;
	}
}
