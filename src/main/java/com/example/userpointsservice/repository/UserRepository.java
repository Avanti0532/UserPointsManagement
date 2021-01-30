package com.example.userpointsservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.userpointsservice.entity.User;

@Repository
public interface UserRepository  extends CrudRepository<User, String>{

	User findByEmail(String email);

}
