package com.example.userpointsservice.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.userpointsservice.dao.UserPointsDAO;
import com.example.userpointsservice.entity.UserPoints;

/**
 * The service class is to hold the business logic of the user points webservice
 * @version 1.0
 */
@Service
public class UserPointsService {

	@Autowired
	private UserPointsDAO userPointsDAO;
	
	public UserPoints addPoints(UserPoints points) {
		return userPointsDAO.addPoints(points) ;
	}

	public HashMap<String, Integer> deductPoints(int points) {
		return userPointsDAO.deductPoints(points);
	}

	public List<UserPoints> getBalancePoints() {
		return userPointsDAO.getBalancePoints();
	}

}
