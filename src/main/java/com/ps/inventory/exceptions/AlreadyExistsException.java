package com.ps.inventory.exceptions;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AlreadyExistsException  extends ResponseStatusException{
	
	private String message ;
	
	public AlreadyExistsException(HttpStatus status, String reason) {
		super(status, reason);
		
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}