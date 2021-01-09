package com.ps.inventory.model;
import java.time.LocalDateTime;
import java.util.Set;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;



@Table(value="Inventory")

@JsonIgnoreProperties(ignoreUnknown = true)

public class Inventory implements Persistable<Integer> {

	@Id
	@Column("id")
	private Integer id;
	@Column("userName")
	private String userName;
	@Column("password")
	private String password;
	@Column("mobile")
	private Long mobile;
	@Column("email")
	private String email;
	@Column("createdBy")
	private String createdBy;
	@Column("lastUpdatedBy")
	private String lastUpdatedBy;
	@Column("currentStatus")
	private String currentStatus;
	@Column("createdTime")
	private java.time.LocalDateTime createdTime;
	@Column("lastUpdatedTime")
	private java.time.LocalDateTime lastUpdatedTime;
	@Column("userType")
	private String userType;
	@Transient
	private Set<String> roles;
	
	@Transient
	private boolean newUser;
	
	
	
	public Inventory() {
		super();
	}



	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

}
