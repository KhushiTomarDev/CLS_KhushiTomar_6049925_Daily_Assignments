package cg.demo.SpringAssignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.demo.SpringAssignment.Assignment1.Employee;



//For Assignment 1

public class App {
    public static void main(String[] args) {
        System.out.println( "App is Starting!" );
        
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConf.xml");
        Employee e1 = (Employee)ac.getBean("emp1");  
        System.out.println( e1 );
      
        System.out.println( "App is Ending!" );
    }
}
