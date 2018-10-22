package com.vzw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.vzw.beans.SampleBean;

@Configuration
public class AppConfig {

	//Registering Sample Bean
	@Bean
	public SampleBean getBean(){
		SampleBean sb= new SampleBean("Komal",25,100);
		System.out.println(sb.toString());
		return sb;
	}
	
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
	
}
