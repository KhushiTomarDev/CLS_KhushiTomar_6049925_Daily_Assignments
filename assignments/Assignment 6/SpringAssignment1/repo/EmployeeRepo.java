package cg.demo.SpringAssignment1.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cg.demo.SpringAssignment1.beans.Employee;

@Repository
public class EmployeeRepo implements IEmployeeRepo {

    private Map<Integer, Employee> emp = new HashMap<>();

    // CREATE
    @Override
    public void addEmployee(Employee e) {

        int id = e.getEmpid();

        if (emp.containsKey(id)) {
            System.out.println("Employee with ID " + id + " already exists!");
            return;
        }

        emp.put(id, e);
        System.out.println("Employee added successfully!");
    }

    // READ BY ID
    @Override
    public void viewEmployeebyID(int id) {

        if (!emp.containsKey(id)) {
            System.out.println("Employee with ID " + id + " does not exist!");
            return;
        }

        Employee e = emp.get(id);

        System.out.println("Employee Info:");
        System.out.println("Employee ID: " + e.getEmpid());
        System.out.println("Employee Name: " + e.getEname());
        System.out.println("Employee Salary: " + e.getSalary());
    }

    // READ ALL
    @Override
    public void viewAllEmployees() {

        if (emp.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        for (Employee e : emp.values()) {
            System.out.println("-------------------");
            System.out.println("Employee ID: " + e.getEmpid());
            System.out.println("Employee Name: " + e.getEname());
            System.out.println("Employee Salary: " + e.getSalary());
        }
    }

    // UPDATE
    @Override
    public void updateEmployee(Employee e) {

        int id = e.getEmpid();

        if (!emp.containsKey(id)) {
            System.out.println("Employee with ID " + id + " does not exist!");
            return;
        }

        emp.put(id, e);
        System.out.println("Employee updated successfully!");
    }

    // DELETE
    @Override
    public void deleteEmployee(int id) {

        if (!emp.containsKey(id)) {
            System.out.println("Employee with ID " + id + " does not exist!");
            return;
        }

        emp.remove(id);
        System.out.println("Employee deleted successfully!");
    }
}