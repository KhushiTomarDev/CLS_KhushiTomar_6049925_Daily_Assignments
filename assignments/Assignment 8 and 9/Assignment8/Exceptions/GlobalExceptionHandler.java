package com.example.Assignment8.Exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EmployeeIdNotFound.class)
    public ResponseEntity<String> handlerForIdNotFoundException(EmployeeIdNotFound ee) {
        return new ResponseEntity<>(ee.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MobileNumberDoesNotExistsForEmployeeException.class)
    public ResponseEntity<String> handlerForMobileNumberDoesNotExistsForEmployeeException(MobileNumberDoesNotExistsForEmployeeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    	
    }
    
    @ExceptionHandler(DepartmentNameNotFoundException.class)
    public ResponseEntity<String> handlerForDepartmentNameNotFoundException(DepartmentNameNotFoundException e1) {
        return new ResponseEntity<>(e1.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ee) {

        List<FieldError> fieldErrors = ee.getFieldErrors();
        Map<String, String> errors = new HashMap<>();

        for (FieldError fe : fieldErrors) {
            errors.put(fe.getField(), fe.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}