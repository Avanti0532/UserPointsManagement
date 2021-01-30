package com.example.userpointsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.userpointsservice.entity.User;
import com.example.userpointsservice.entity.UserPoints;
import com.example.userpointsservice.service.UserPointsService;
import com.example.userpointsservice.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Rest controller class to perform add/update/get operations on the user points using POST/GET endpoints
 * @version 1.0
 */
@RestController
public class UserPointsController {
	
	@Autowired
	private UserPointsService service;
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "POST Endpoint to add points for a user",notes = "This endpoint is used to add points of a user per payer.")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Ok",response = UserPoints.class),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	@PostMapping(path="add-points", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addPoints(@RequestBody UserPoints points, @RequestParam("email") String email) {
		 User user = userService.findUserByEmail(email);
		 if(user!=null) {
			 points.setUser(user);
			 UserPoints userPoints = service.addPoints(points);
			 return ResponseEntity.ok().body(userPoints);
		 }
		 	return ResponseEntity.badRequest().body("Invalid user");
	}
	
	@ApiOperation(value = "PUT Endpoint to update points of a user based on user email id",notes = "This endpoint is used to update points spent by the user. The oldest points"
			+ "will be spent first.")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Ok", responseContainer = "Map"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	@PutMapping(path="deduct-points")
	public ResponseEntity<Object> deductPoints(@RequestParam(name="points")int points, @RequestParam(name="email") String email){
		return ResponseEntity.ok().body(service.deductPoints(points, email));
	}
	
	@ApiOperation(value = "GET Endpoint to retrieve points of a user based on user email id",notes = "This endpoint is used to retrieve remaining points of a user")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Ok", response = UserPoints.class, responseContainer = "List"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	@GetMapping(path="get-points", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getBalancePoints(@RequestParam("email") String email){
		return ResponseEntity.ok().body(service.getBalancePoints(email));
	}
}
