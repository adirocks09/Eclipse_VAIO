package vzDatabase.contollers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@RequestMapping("/view")
	public ModelAndView viewDB(){
		
	/*	Integer[] id=new Integer[100];
		Double[] salary=new Double[100];
		String name[]=new String[100];
		String designation[]=new String[100];*/
		
		List<Integer> id= new ArrayList<Integer>(); 
		List<Double> salary= new ArrayList<Double>(); 
		List<String> name= new ArrayList<String>(); 
		List<String> designation= new ArrayList<String>(); 


		int i,j,k,l;
		i=j=k=l=0;
		try{ 
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","Database_adi","Aditya001#");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from employee");  
			
			while(rs.next()) { 
			id.add(rs.getInt(1));
			name.add(rs.getString(2));
			designation.add(rs.getString(3));
			salary.add(rs.getDouble(4));
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));  

			}
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		 
		ModelAndView viewDatabase=new ModelAndView();
		viewDatabase.addObject("id", id);
		viewDatabase.addObject("name", name);
		viewDatabase.addObject("designation", designation);
		viewDatabase.addObject("salary", salary);
		viewDatabase.setViewName("viewDB");
		return viewDatabase;

			}
	}


