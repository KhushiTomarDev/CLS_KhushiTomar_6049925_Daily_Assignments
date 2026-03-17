package cg.demo.SpringAssignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.demo.SpringAssignment.Assignment2.Employee1;

//For Assignment 2

public class App1 {
	
	public static void main(String[] args) {
	  System.out.println( "App is Starting!" );
      
      ApplicationContext ac = new ClassPathXmlApplicationContext("springConf.xml");
      Employee1 e1 = (Employee1)ac.getBean("emp2");  
      System.out.println( e1 );
    
      System.out.println( "App is Ending!" );
}
}