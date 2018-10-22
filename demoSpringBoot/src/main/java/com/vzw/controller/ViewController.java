package com.vzw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
//@PropertySource("classpath:my-custom.properties")
public class ViewController {
	
	   // Properties can be directly injected from application.properties

	    @Value("${spring.datasource.url}")	 // Spring Defined Properties  
	    private String jdbcURL;
	    
		@Value("${welcome.message:Hello World}")	// User Defined Properties
		private String customMessage;
		
		
		// Returns thymleaf tempalate : welcome.html
		@RequestMapping(value="/welcome", method = RequestMethod.GET)
		public String welcome(Map<String, Object> model) {
			model.put("message", this.customMessage);
			System.out.println(jdbcURL);
			System.out.println(customMessage);
			return "welcome";  
		}
		
		// Returns String Object : "welcome" as String Object
		@RequestMapping(value="/welcome2", method = RequestMethod.GET)
		public @ResponseBody String welcome2(Map<String, Object> model) {
			model.put("message", this.customMessage);
			System.out.println(jdbcURL);
			System.out.println(customMessage);
			return "welcome";   
		}
		

		@RequestMapping(value="/sumPOST" , method=RequestMethod.POST)
		public String sumPOST(Map<String, Object> model , HttpServletRequest request , HttpServletResponse response) {
			String num1 =request.getParameter("num1");
			String num2 =request.getParameter("num2");
			String num3 =request.getParameter("txtboxName");
			String result=null ;
			
			if(num1!= null && num2 !=null){
				int i=Integer.parseInt(num1);
				int j=Integer.parseInt(num2);
				int sum =i+j;
				result=String.valueOf(sum);
			}
			
			List<String> names = new ArrayList<String>();
			names.add("Aditya");
			names.add("Komal");
			names.add("Isha");
			names.add("Priya");
			
			model.put("sum",result);
			model.put("nameList",names);

			return "sum";
		}
		
		@RequestMapping(value="/sumGET" , method=RequestMethod.GET)
		public String sumGET(Map<String, Object> model , HttpServletRequest request , HttpServletResponse response) {
			String num1 =request.getParameter("num3");
			String num2 =request.getParameter("num4");
			String num3 =request.getParameter("txtboxName");
			String result=null ;
			
			if(num1!= null && num2 !=null){
				int i=Integer.parseInt(num1);
				int j=Integer.parseInt(num2);
				int sum =i+j;
				result=String.valueOf(sum);
			}
			
			List<String> names = new ArrayList<String>();
			names.add("Aditya");
			names.add("Komal");
			names.add("Isha");
			names.add("Priya");
			
			model.put("sum",result);
			model.put("nameList",names);

			return "sum";
		}

		
		@RequestMapping(value="/pageRedirect", method = RequestMethod.GET)
		public String pageRedirect(Map<String, Object> model) {
			model.put("pageMessage","You have been redirected to a different page");
			return "redirect/page1";
		}
}
