package com.bway.springproject.dao;

import com.bway.springproject.model.User;

public interface UserDao {
	
	void signup(User u);
	User sigup(String username,String password);

}
