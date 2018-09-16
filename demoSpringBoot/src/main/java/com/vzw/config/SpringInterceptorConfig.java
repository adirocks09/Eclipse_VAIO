package com.vzw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.vzw.interceptor.Interceptor1;
import com.vzw.interceptor.Interceptor2;

@Configuration
public class SpringInterceptorConfig extends WebMvcConfigurerAdapter  {
   
   @Autowired
   Interceptor1 interceptor1;
   
   @Autowired
   Interceptor2 interceptor2;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
	  //registry defines sequence of interceptors 
	  
	  //Interceptor 1-->Interceptor2 
      registry.addInterceptor(interceptor1);
      registry.addInterceptor(interceptor2);
      
      //Interceptor 2-->Interceptor1 
      //registry.addInterceptor(interceptor2);
      //registry.addInterceptor(interceptor1);
      
      //Including and exluding url patterns
      //registry.addInterceptor(interceptor1).addPathPatterns("/api").excludePathPatterns("/api/hello");
      
	  System.out.println("------Interceptor Configuration Completed---------- ");

   }
 
}