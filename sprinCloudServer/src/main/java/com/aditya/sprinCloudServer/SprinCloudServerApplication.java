package com.aditya.sprinCloudServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigServer
public class SprinCloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinCloudServerApplication.class, args);
	}
}
