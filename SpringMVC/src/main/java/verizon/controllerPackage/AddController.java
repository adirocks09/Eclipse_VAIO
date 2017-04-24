package verizon.controllerPackage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import verizon.servicePackage.AddService;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response){
		 
		int n1=Integer.parseInt(request.getParameter("num1"));
		int n2=Integer.parseInt(request.getParameter("num2"));
		//int n3=n1+n2;  // directly adding the numbers
		
		AddService service1=new AddService();//calling service to add the numbers
		int n3=service1.add(n1, n2);
		

		ModelAndView view=new ModelAndView();
		
		view.addObject("sum",n3);
		view.setViewName("display.jsp");
		//view.setViewName("display2.jsp");
		
		

		System.out.println("Result="+n3);
		return view;
	}


}
