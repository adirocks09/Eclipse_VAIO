package vzDatabase.contollers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String status;
    int i;
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response){
		
		int t1=Integer.parseInt(request.getParameter("E_id"));
		int t2=Integer.parseInt(request.getParameter("E_sal"));
		String t3=request.getParameter("E_name");
		String t4=request.getParameter("E_desg");
		ServletContext context=getServletContext(); 
	    ServletConfig config=getServletConfig();

        ModelAndView viewDatabase=new ModelAndView();
		try{ 
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","Database_adi","Aditya001#"); 
			Statement stmt=con.createStatement();  
			int i=stmt.executeUpdate("insert into employee values('"+t1+"','"+t3+"','"+t4+"','"+t2+"')");  

			if(i!=0)
				status="is Successful";
			else 
				status="has failed";
			
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
		viewDatabase.addObject("status", status);
		viewDatabase.setViewName("add2");
		return viewDatabase;

			}
	
	
}
