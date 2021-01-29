package com.example.userpointsservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.userpointsservice.entity.UserPoints;

/**
 * repository interface to save and retrieve user points
 * @version 1.0
 */
@Repository
public interface UserPointsRepository extends CrudRepository<UserPoints, String> {
	
	@Query(value = "SELECT p from UserPoints p WHERE p.points!=0 order by p.transactionDate asc")
	List<UserPoints> findPayers();
}
