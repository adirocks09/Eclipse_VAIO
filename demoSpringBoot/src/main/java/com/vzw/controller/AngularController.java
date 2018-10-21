package com.vzw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vzw.vo.RequestVO;

@Controller
@CrossOrigin(origins = "http://localhost:7200")
public class AngularController {

	@RequestMapping(value="/angularSpringboot/getList",method=RequestMethod.GET)
	public @ResponseBody List<RequestVO> getListForAngularApplication() {
		
		List<RequestVO> responseList = new ArrayList<RequestVO>();
		responseList.add(new RequestVO("Anil" ,40 , 38000) );
		responseList.add(new RequestVO("Asha" ,45 , 8000) );
		responseList.add(new RequestVO("Arjun" ,50 , 28000) );
		
		return responseList;
	}
}
