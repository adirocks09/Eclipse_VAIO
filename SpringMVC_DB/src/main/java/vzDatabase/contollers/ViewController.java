package vzDatabase.contollers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@RequestMapping("/view")
	public ModelAndView viewDB(){
		
		Integer[] id=new Integer[100];
		Double[] salary=new Double[100];
		String name[]=new String[100];
		String designation[]=new String[100];
		int i,j,k,l;
		i=j=k=l=0;
		try{ 
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","Database_adi","Aditya001#");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from employee");  
			
			while(rs.next()) { 
			id[i++]=rs.getInt(1);
			name[j++]=rs.getString(2);
			designation[k++]=rs.getString(3);
			salary[l++]=rs.getDouble(4);
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));  

			}
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		 
		ModelAndView viewDatabase=new ModelAndView();
		viewDatabase.addObject("ID", id);
		viewDatabase.addObject("NAME", name);
		viewDatabase.addObject("DESG", designation);
		viewDatabase.addObject("SALARY", salary);
		viewDatabase.setViewName("viewDB.jsp");
		return viewDatabase;

			}
	
	

	
	
	
		
	}


