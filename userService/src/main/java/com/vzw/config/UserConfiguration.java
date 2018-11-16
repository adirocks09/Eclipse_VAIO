package com.vzw.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfiguration {
	
	
	//@LoadBalanced		// Load balance between service instances running at different ports.
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
