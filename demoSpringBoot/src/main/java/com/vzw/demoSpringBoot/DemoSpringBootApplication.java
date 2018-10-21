package com.vzw.demoSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages="com")// for scanning and registering component and service beans
@EnableJpaRepositories(basePackages="com.vzw.repository") // for scanning and registering repository beans
@EntityScan(basePackages="com.vzw.entity")// for scanning and registering entity beans
@EnableSwagger2
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);
	}
}
