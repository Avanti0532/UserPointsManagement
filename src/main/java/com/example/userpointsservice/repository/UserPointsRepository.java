package com.example.userpointsservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.userpointsservice.entity.UserPoints;

/**
 * repository interface to save and retrieve user points
 * @version 1.0
 */
@Repository
public interface UserPointsRepository extends CrudRepository<UserPoints, String> {
	

	@Query(value = "SELECT * from USER_POINTS p WHERE (p.points!=0 and p.user=(SELECT id FROM USER u WHERE u.email=:email)) order by p.transaction_date asc", nativeQuery = true)
	List<UserPoints> findPayers(@Param("email") String email);
	
	
	@Query(value = "SELECT * FROM USER_POINTS p WHERE p.user=(SELECT id FROM USER u WHERE u.email=:email)", nativeQuery = true)
	List<UserPoints> findPointsByEmail(@Param("email")String email);
}
