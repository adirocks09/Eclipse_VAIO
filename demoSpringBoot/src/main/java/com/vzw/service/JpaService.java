package com.vzw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vzw.entity.User;
import com.vzw.repository.BikeRepository;
import com.vzw.repository.UserRepository;
import com.vzw.vo.JpaResponseVO;

@Service
public class JpaService {

	@Autowired
	private UserRepository userRepository; 
	@Autowired
	private BikeRepository bikeRepository;
	
	public JpaResponseVO getEntityDetails(){
		List<User> userDetails = userRepository.findAll();
		JpaResponseVO response = new JpaResponseVO ();
		for(User u :userDetails ){
			System.out.println(u.getUserName());
			System.out.println(u.getBikeList());
			
		}
	    return response;
	}
}
