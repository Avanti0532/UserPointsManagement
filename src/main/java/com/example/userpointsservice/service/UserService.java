package com.example.userpointsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userpointsservice.dao.UserDAO;
import com.example.userpointsservice.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public User findUserByEmail(String email) {
		return userDAO.findByEmail(email);
	}

}
