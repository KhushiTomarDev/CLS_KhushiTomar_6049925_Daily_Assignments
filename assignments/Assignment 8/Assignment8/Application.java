package com.example.Assignment8;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.Assignment8.Controller.EmployeeController;

@SpringBootApplication
public class Application {

	    @Autowired
	    private EmployeeController controller;  

	    public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
	}
	


