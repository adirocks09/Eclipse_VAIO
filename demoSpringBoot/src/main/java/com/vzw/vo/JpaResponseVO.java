package com.vzw.vo;

import java.util.List;

import com.vzw.entity.User;

public class JpaResponseVO {

	private List<User> userList;
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}
