package vzDatabase.contollers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request,HttpServletResponse response){
	
		String name=request.getParameter("userName");
		String pwd=request.getParameter("pwd");
		ModelAndView homepage=new ModelAndView();

		if(name.equals("aditya")&&pwd.equals("12345"))
		    homepage.setViewName("homepage.jsp");
		
		else 
			homepage.setViewName("error.jsp");
		
		
		return homepage;
		
	
		
	}
	

}
