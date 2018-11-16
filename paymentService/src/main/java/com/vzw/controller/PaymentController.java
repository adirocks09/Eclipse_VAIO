package com.vzw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/payment")
public class PaymentController {


	@RequestMapping(value="/options" , method=RequestMethod.GET)
	public List <String> nameList (){
		List <String> names = new ArrayList<String>();
		names.add("Credit Card");
		names.add("Debit Card");
		names.add("Paytm Wallet");
		names.add("PhonePe / UPI");
		return names;
	}



}
