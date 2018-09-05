package com.vzw.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SpringAspect {
	 @Pointcut("execution(* com.vzw.controller.RestApiController.*(..))")  
	    public void k(){}//pointcut name  
	      
	    @Before("k()")//applying pointcut on before advice  
	    public void myadvice(JoinPoint jp)//it is advice (before advice)  
	    {  
	        System.out.println("Spring AOP");  
	        System.out.println("Method Signature: "  + jp.getSignature());  
	    }  
	
}
