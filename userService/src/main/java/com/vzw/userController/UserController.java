package com.vzw.userController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public List<String> nameList() {
		List<String> names = new ArrayList<String>();
		names.add("Anurag Anand");
		names.add("Aditya Anand");
		names.add("Akanshi Anand");
		return names;
	}

	@RequestMapping(value="/paymentOptions" , method=RequestMethod.GET)
	public Object paymentOptionsList (){
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    
		ResponseEntity responseEntity = restTemplate.exchange("http://localhost:9300/payment/options", HttpMethod.GET, entity,Object.class);
		return responseEntity.getBody();
	}

}
