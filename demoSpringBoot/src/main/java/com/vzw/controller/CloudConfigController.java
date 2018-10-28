package com.vzw.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cloudConfig")
@RefreshScope
public class CloudConfigController {

	@Value("${company.name: Default Server }")	   // inject via application.properties
	private String companyName;
	
	@RequestMapping(value="/company", method = RequestMethod.GET)
	public String cloudConfig(Map<String, Object> model) {
		model.put("cloudConfigmessage", this.companyName);
			System.out.println(companyName);
		return "cloudConfigMessage";
	}
}
