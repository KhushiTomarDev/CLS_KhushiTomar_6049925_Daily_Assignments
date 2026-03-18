package cg.demo.SpringAssignment1.ServiceLayer;

import cg.demo.SpringAssignment1.beans.Employee;

public interface IServiceLayer {

    void addEmployee(Employee e);
    void viewEmployeeByID(int id);
    void viewAllEmployees();
    void updateEmployee(Employee e);
    void deleteEmployee(int id);
}