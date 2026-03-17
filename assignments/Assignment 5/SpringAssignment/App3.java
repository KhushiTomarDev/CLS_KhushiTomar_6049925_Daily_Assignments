package cg.demo.SpringAssignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.demo.SpringAssignment.Assignment3.SBU;



public class App3 {
	public static void main( String[] args )
    {
        System.out.println( "Starting Application...." );
        
        ApplicationContext ac =new ClassPathXmlApplicationContext("springConfig1.xml"); 
        
        SBU sbu1= (SBU) ac.getBean("sbu1");

        System.out.println(sbu1);

        System.out.println( "Closing Application...." );
    }

}