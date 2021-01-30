package com.example.userpointsservice.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * This is a POJO class for storing user points
 * @version 1.0
 */
@Data
@Entity
@ApiModel(description="This is a POJO class representing the points earned/spent by the user per payer")
public class UserPoints {
	
	@Id
	@JsonIgnore
	@ApiModelProperty(value="Unique id",
	name="id",
	hidden=true)
	private String id;
	
	@ApiModelProperty(
			value = "name of the payer", 
			name = "payerName", 
			example = "DANNON")
	private String payerName;
	
	@ApiModelProperty(
			value = "points earned by the user", 
			name = "points", 
			example = "200")
	private int points;
	
	@ApiModelProperty(
			value = "date on which user earned points for a payer", 
			name = "transactionDate", 
			example = "2021-01-29T07:00:00")
	private Date transactionDate;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	public UserPoints() {
		this.id = UUID.randomUUID().toString();
	}

}
