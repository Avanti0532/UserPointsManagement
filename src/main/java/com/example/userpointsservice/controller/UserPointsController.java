package com.example.userpointsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.userpointsservice.entity.UserPoints;
import com.example.userpointsservice.service.UserPointsService;
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
	
	@ApiOperation(value = "POST Endpoint to add points for a user",notes = "This endpoint is used to add points of a user per payer.")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Ok",response = UserPoints.class),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	@PostMapping(path="add-points", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addPoints(@RequestBody UserPoints points ) {
		 UserPoints userPoints = service.addPoints(points);
		 return ResponseEntity.ok().body(userPoints);
	}
	
	@ApiOperation(value = "POST Endpoint to update points for a user",notes = "This endpoint is used to update points spent by the user.")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Ok", responseContainer = "Map"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	@PostMapping(path="deduct-points")
	public ResponseEntity<Object> deductPoints(@RequestParam(name="points")int points){
		return ResponseEntity.ok().body(service.deductPoints(points));
	}
	
	@ApiOperation(value = "GET Endpoint to retrieve points of a user",notes = "This endpoint is used to retrieve remaining points of a user")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Ok", response = UserPoints.class, responseContainer = "List"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	@GetMapping(path="get-points", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getBalancePoints(){
		return ResponseEntity.ok().body(service.getBalancePoints());
	}
}
