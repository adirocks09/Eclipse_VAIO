package vzDatabase.contollers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home" , method = RequestMethod.POST )
	public ModelAndView home(HttpServletRequest request,HttpServletResponse response){
	
		String name=request.getParameter("userName");
		String pwd=request.getParameter("pwd");
		try {
			request.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView homepage=new ModelAndView();

		if(name.equals("aditya")&&pwd.equals("12345"))
		    homepage.setViewName("homepage");
		
		else 
			homepage.setViewName("error");
		
		
		return homepage;
		
	
		
	}
	

}
