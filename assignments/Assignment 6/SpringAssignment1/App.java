package cg.demo.SpringAssignment1;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cg.demo.SpringAssignment1.ServiceLayer.IServiceLayer;
import cg.demo.SpringAssignment1.beans.Employee;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(springConfig.class);

        IServiceLayer service = context.getBean(IServiceLayer.class);

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee by ID");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:

                Employee e = context.getBean(Employee.class);

                System.out.print("Enter ID: ");
                e.setEmpid(sc.nextInt());

                System.out.print("Enter Name: ");
                e.setEname(sc.next());

                System.out.print("Enter Salary: ");
                e.setSalary(sc.nextDouble());

                service.addEmployee(e);
                break;

            case 2:

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                service.viewEmployeeByID(id);
                break;

            case 3:

                service.viewAllEmployees();
                break;

            case 4:

                Employee updateEmp = context.getBean(Employee.class);

                System.out.print("Enter ID to update: ");
                updateEmp.setEmpid(sc.nextInt());

                System.out.print("Enter New Name: ");
                updateEmp.setEname(sc.next());

                System.out.print("Enter New Salary: ");
                updateEmp.setSalary(sc.nextDouble());

                service.updateEmployee(updateEmp);
                break;

            case 5:

                System.out.print("Enter Employee ID to delete: ");
                int deleteId = sc.nextInt();

                service.deleteEmployee(deleteId);
                break;

            case 6:

                System.out.println("Exiting application...");
                break;

            default:

                System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}