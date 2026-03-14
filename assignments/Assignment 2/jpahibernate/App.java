package cg.demo.jpahibernate;

import cg.demo.jpahibernate.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        System.out.println("Starting App!!!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager em = emf.createEntityManager();

//        Employee emp = new Employee();
//
//        emp.setId(101);
//        emp.setName("Ronit");
//        emp.setSalary(45000);
//        emp.setDepartment("IT");
//
//        em.getTransaction().begin();
//
//        //em.persist(emp);
//
//        System.out.println("Employee has been Added Successfully!!!");
//        
//
//        Employee emp1 = em.find(Employee.class, 2);
//        if(emp1!=null) {
//        	em.remove(emp1);
//        }
//        else {
//        	System.out.println("Record Not found");
//        }
//        em.getTransaction().commit();
        
        

        Scanner sc = new Scanner(System.in);
        EmpDAO service = new EmpDAO();

        while (true) {

            System.out.println("\n1 Insert");
            System.out.println("2 View by ID");
            System.out.println("3 View All");
            System.out.println("4 Update Salary");
            System.out.println("5 Delete");
            System.out.println("6 Find Employee by Mobile");
            System.out.println("7 Find All employee");
            System.out.println("8 Count emp by Dept");
            System.out.println("9 Employee with same salary");
            System.out.println("10 Exit");

            int choice = sc.nextInt();

            switch (choice) {
            
            case 1:
            	 Employee emp = new Employee();

                 System.out.println("Enter ID");
                 emp.setId(sc.nextInt());

                 System.out.println("Enter Name");
                 emp.setName(sc.next());

                 System.out.println("Enter Salary");
                 emp.setSalary(sc.nextInt());

                 System.out.println("Enter Department");
                 emp.setDepartment(sc.next());

                 service.insertEmployee(emp);
                 break;
            
            
            case 2 :
            	 System.out.println("Enter ID");
                 Employee e = service.findEmployee(sc.nextInt());

                 if (e != null)
                     System.out.println(e.getName() + " " + e.getSalary());
                 else
                     System.out.println("Not Found");

                 break;
                 
            case 3 : 

                List<Employee> list = service.getAllEmployees();

                for (Employee emp1 : list)
                    System.out.println(emp1.getId() + " " + emp1.getName());

                break;

            case 4:

                System.out.println("Enter ID");
                int id = sc.nextInt();

                Employee emp2 = service.findEmployee(id);

                if (emp2 != null) {

                    System.out.println("Enter new salary");
                    emp2.setSalary(sc.nextInt());

                    service.updateEmployee(emp2);
                }

                break;

            case 5:

                System.out.println("Enter ID");
                service.deleteEmployee(sc.nextInt());

                break;

            case 6:

            	System.out.println("Enter Mobile");
            	String mob = sc.next();

            	List<Employee> emp1 = service.findEmployeeByMobile(mob);

            	for(Employee e1 : emp1)
            	System.out.println(e1.getName());

            	break;
                
            case 7:

            	List<Employee> all = service.findAllEmployees();

            	for(Employee e1 : all)
            	System.out.println(e1.getId()+" "+e1.getName());

            	break;
            	
            	
            case 8:

            	List<Object[]> list1 = service.countEmployeeByDept();

            	for(Object[] obj : list1)
            	System.out.println(obj[0] + " : " + obj[1]);

            	break;
            
            
        case 9:

        	List<Employee> same = service.employeesWithSameSalary();

        	for(Employee e1 : same)
        	System.out.println(e1.getName()+" "+e1.getSalary());

        	break;
        	
        case 10:
            System.exit(0);
        
        }
        
        
               
        System.out.println("Ending App!!!");

        em.close();
        emf.close();
    }
    }}
