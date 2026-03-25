package com.example.Assignment8.Exceptions;

public class EmployeeIdNotFound extends RuntimeException {
	EmployeeIdNotFound(String message){
		super(message);
	}

}
