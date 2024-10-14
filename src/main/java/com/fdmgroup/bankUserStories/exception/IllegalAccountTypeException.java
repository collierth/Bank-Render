package com.fdmgroup.bankUserStories.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IllegalAccountTypeException extends RuntimeException {

	public IllegalAccountTypeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
