package com.aditya.sprinCloudClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloud")
// Actuator Dependency is must
// Hit the endpoint [POST : http://localhost:8085/actuator/refresh] to refresh the data
@RefreshScope
public class CloudController {

    @Autowired
    private Environment env;


    @GetMapping("/test")
    public String testCloud(){
        String s = env.getProperty("company.name");
        System.out.println("Hello " + s);
        return s;
    }
}
