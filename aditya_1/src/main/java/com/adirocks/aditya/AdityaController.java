package com.adirocks.aditya;

import java.util.ResourceBundle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping({"/adiWeb"})
public class AdityaController
{
  @RequestMapping(value = {"/displayDetails"}, method = {RequestMethod.GET})
  public ModelAndView displayDetails() {
    String employeeName = ResourceBundle.getBundle("adityaCustom").getString("employeeName");
    String employeeDesignation = ResourceBundle.getBundle("adityaCustom").getString("employeeDesignation");
    System.out.println(employeeName);
    System.out.println(employeeDesignation);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("detailsPage");
    modelAndView.addObject("employeeName", employeeName);
    modelAndView.addObject("employeeDesignation", employeeDesignation);
    return modelAndView;
  }

  
  @RequestMapping(value = {"/showIndexpage"}, method = {RequestMethod.GET})
  public String showIndexpage() { return "myIndexPage"; 
  }
}
