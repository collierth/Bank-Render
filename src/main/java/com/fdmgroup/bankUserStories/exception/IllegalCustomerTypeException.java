package com.fdmgroup.bankUserStories.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IllegalCustomerTypeException extends RuntimeException {

	public IllegalCustomerTypeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
