package cg.demo.SpringAssignment1.repo;

import cg.demo.SpringAssignment1.beans.Employee;

public interface IEmployeeRepo {
	void addEmployee(Employee e);
	void viewEmployeebyID(int id);
	void viewAllEmployees();
	void updateEmployee(Employee e);
	void deleteEmployee(int id);
	}

