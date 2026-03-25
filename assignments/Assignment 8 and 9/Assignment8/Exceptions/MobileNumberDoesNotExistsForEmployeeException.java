package com.example.Assignment8.Exceptions;

public class MobileNumberDoesNotExistsForEmployeeException extends RuntimeException {
	MobileNumberDoesNotExistsForEmployeeException(String msg){
		super(msg);
	}
}
