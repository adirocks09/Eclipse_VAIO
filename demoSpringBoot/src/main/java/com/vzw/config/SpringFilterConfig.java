package com.vzw.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vzw.filter.Filter3;
import com.vzw.filter.Filter4;

@Configuration
public class SpringFilterConfig {

	//Filter3 Configuration
	@Bean
	public FilterRegistrationBean<Filter3> loggingFilter3(){
	    FilterRegistrationBean<Filter3> registrationBean 
	      = new FilterRegistrationBean<>();
	    registrationBean.setFilter(new Filter3());
	    registrationBean.addUrlPatterns("/welcome");
	    return registrationBean;    
	}
	
	//Filter4 Configuration
	@Bean
	public FilterRegistrationBean<Filter4> loggingFilter4(){
	    FilterRegistrationBean<Filter4> registrationBean 
	      = new FilterRegistrationBean<>();
	    registrationBean.setFilter(new Filter4());
	    registrationBean.addUrlPatterns("/sum");
	    return registrationBean;    
	}
}
