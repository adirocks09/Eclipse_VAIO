package com.vzw.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/CloudConfig")
public class CloudConfigController {

	@Value("${CloudConfig.message: Default Server }")	   // inject via application.properties
	private String cloudConfigmessage;
	
	@RequestMapping(value="/Home", method = RequestMethod.GET)
	public String cloudConfig(Map<String, Object> model) {
		model.put("cloudConfigmessage", this.cloudConfigmessage);
		return "cloudConfigmessage";
	}
}
