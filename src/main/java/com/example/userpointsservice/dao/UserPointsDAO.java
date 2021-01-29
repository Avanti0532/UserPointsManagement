package com.example.userpointsservice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.userpointsservice.entity.UserPoints;
import com.example.userpointsservice.repository.UserPointsRepository;

/**
 * DAO layer to perform CRUD operations based on the data provided by the user
 * @version 1.0
 */
@Repository
public class UserPointsDAO {
	
	@Autowired
	private UserPointsRepository repository;

	public UserPoints addPoints(UserPoints points) {
		return repository.save(points);
	}

	public HashMap<String, Integer> deductPoints(int points) {
		List<UserPoints> payersList = repository.findPayers();
		HashMap<String, Integer> map = new HashMap<>();
		int count = 0;
		for(UserPoints p: payersList) {
			int uPoints = p.getPoints();
			String name = p.getPayerName();
			count++;
			if(uPoints<=points) {
				points = points - uPoints;
				p.setPoints(0);
				createMap(map, name, uPoints);
			}else {
				p.setPoints(uPoints-points);
				createMap(map, name, points);
				break;
			}
		}
		List<UserPoints> newPayersList = payersList.stream().limit(count).collect(Collectors.toList());
		repository.saveAll(newPayersList);
		return map;
	}
	
	
	private void createMap(HashMap<String, Integer> map, String name, int points) {
		if(map.containsKey(name)) {
			map.put(name, map.get(name) - points);
		}else {
			map.put(name, -points);
		}
	}

	public List<UserPoints> getBalancePoints() {
		return (List<UserPoints>) repository.findAll();
	}	
}
