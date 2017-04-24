package controllerPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {
	
	@RequestMapping("/login")
	public void display(){
		System.out.println("helllooooo ");
	}

}
