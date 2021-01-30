package com.example.userpointsservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.userpointsservice.entity.User;
import com.example.userpointsservice.repository.UserRepository;

@Repository
public class UserDAO {

	@Autowired
	private UserRepository userRepository;
	
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

}
