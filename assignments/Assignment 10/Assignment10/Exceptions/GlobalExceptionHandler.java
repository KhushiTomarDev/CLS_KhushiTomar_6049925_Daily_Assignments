package com.example.Assignment7.Exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//Global exception handler
@RestControllerAdvice
public class GlobalExceptionHandler {

	 //Controller Level Exception Handling
    @ExceptionHandler(TraineeIdNotFound.class)
    ResponseEntity<String> handlerForIdNotFoundException(TraineeIdNotFound ee)  {
    	return new ResponseEntity<>(ee.getMessage(),HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    ResponseEntity<String> handlerForIdNotFoundExcepti(MethodArgumentNotValidException ee)  {
//    	return new ResponseEntity<>("I handled ",HttpStatus.BAD_REQUEST);
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Map<String, String>>handlerForValiddBeanException(MethodArgumentNotValidException ee)  {
    	List<FieldError> fieldErrors = ee.getFieldErrors();
    	Map<String,String> maps = new HashMap<>();
    	for(FieldError fe : fieldErrors) {
    		maps.put(fe.getField(), fe.getDefaultMessage());
    	}
    	
    	return new ResponseEntity<>(maps,HttpStatus.BAD_REQUEST);
    }
}
