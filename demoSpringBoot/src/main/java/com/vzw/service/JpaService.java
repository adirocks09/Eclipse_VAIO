package com.vzw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vzw.beans.JDBCBean;
import com.vzw.entity.User;
import com.vzw.repository.BikeRepository;
import com.vzw.repository.UserRepository;
import com.vzw.vo.Employee;
import com.vzw.vo.JpaResponseVO;

@Service
public class JpaService {

	@Autowired
	private UserRepository userRepository; 
	@Autowired
	private BikeRepository bikeRepository;
	@Autowired
	private JDBCBean jdbcRepo;
	
	public JpaResponseVO getEntityDetails(){
		List<User> userDetails = userRepository.findAll();
		JpaResponseVO response = new JpaResponseVO ();
		for(User u :userDetails ){
			System.out.println(u.getUserName());
			System.out.println(u.getBikeList());
			
		}
	    return response;
	}
	
	public List<Employee> viewCallJDBCTempalate(){
		List<Employee> empDetails = jdbcRepo.getEmpDetails();
	    return empDetails;
	}
	
	public List<Employee> addCallJDBCTempalate(Employee emp) {
		List<Employee> empDetails = jdbcRepo.addEmpDetails(emp);
	    return empDetails;
	}
	
	public List<Employee> addCallNamedJDBCTempalate(Employee emp) {
		List<Employee> empDetails = jdbcRepo.addNamedEmpDetails(emp);
	    return empDetails;
	}

	
}
