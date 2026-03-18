package cg.demo.SpringAssignment1.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.demo.SpringAssignment1.beans.Employee;
import cg.demo.SpringAssignment1.repo.IEmployeeRepo;

@Service
public class ServiceLayer implements IServiceLayer {

    @Autowired
    private IEmployeeRepo repo;

    @Override
    public void addEmployee(Employee e) {
        repo.addEmployee(e);
    }

    @Override
    public void viewEmployeeByID(int id) {
        repo.viewEmployeebyID(id);
    }

    @Override
    public void viewAllEmployees() {
        repo.viewAllEmployees();
    }

    @Override
    public void updateEmployee(Employee e) {
        repo.updateEmployee(e);
    }

    @Override
    public void deleteEmployee(int id) {
        repo.deleteEmployee(id);
    }
}