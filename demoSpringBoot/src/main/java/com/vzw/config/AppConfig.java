package com.vzw.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vzw.beans.SampleBean;

@Configuration
public class AppConfig {

	
	@Bean
	public SampleBean getBean(){
		SampleBean sb= new SampleBean("Komal",25,100);
		System.out.println(sb.toString());
		return sb;
	}
}
