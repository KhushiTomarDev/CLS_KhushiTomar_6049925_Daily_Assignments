package com.example.Assignment8.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assignment8.Dto.DepartmentWiseEmployeeDTO;
import com.example.Assignment8.Entities.Department;
import com.example.Assignment8.Entities.Employee;
import com.example.Assignment8.Repository.DepartmentRepository;
import com.example.Assignment8.Repository.EmployeeRepository;



@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private DepartmentRepository deptRepo;

    public void insertEmployee(Employee e, int deptId) {

        Department d = deptRepo.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        e.setDepartment(d);

        // 🔥 ADD THIS (IMPORTANT)
        d.getEmployees().add(e);

        empRepo.save(e);
    }

    public List<Employee> getAllEmployees() {
        return empRepo.getAllEmployeesWithDept();
    }

    public List<DepartmentWiseEmployeeDTO> countByDept() {
        return empRepo.countEmployeesByDept();
    }

    public List<Employee> getByDeptName(String name) {
        return empRepo.findByDepartment_Name(name);
    }

    public Employee getByMobile(String mobile) {
        return empRepo.findByMobile(mobile);
    }
    public void updateEmployee(int id, int deptId, Employee e) {

        Employee existing = empRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Department d = deptRepo.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existing.setName(e.getName());
        existing.setSalary(e.getSalary());
        existing.setMobileNumbers(e.getMobileNumbers());
        existing.setDepartment(d);

        empRepo.save(existing);
    }
}


//when no controller layer
//@Service
//public class EmployeeService {
//
//    @Autowired
//    private EmployeeRepository empRepo;
//
//    @Autowired
//    private DepartmentRepository deptRepo;
//
//    // 1. Insert Employee
//    public void insertEmployee(Employee e, int deptId) {
//
//        Department d = deptRepo.findById(deptId).orElse(null);
//        e.setDepartment(d);
//
//        empRepo.save(e);
//    }
//
//    // 2. Fetch all
//    public void fetchAll() {
//
//        List<Employee> list = empRepo.getAllEmployeesWithDept();
//
//        list.forEach(e -> {
//            System.out.println(e.getName() + " | " +
//                    e.getDepartment().getName() + " | " +
//                    e.getDepartment().getManagerName());
//        });
//    }
//
//    // 3. Count
//    public void countByDept() {
//
//        List<Object[]> list = empRepo.countEmployeesByDept();
//
//        list.forEach(obj -> {
//            System.out.println(obj[0] + " : " + obj[1]);
//        });
//    }
//
//    // 4. By department name
//    public void getByDeptName(String name) {
//
//        empRepo.findByDepartment_Name(name)
//                .forEach(e -> System.out.println(e.getName()));
//    }
//
//    // 5. By mobile
//    public void getByMobile(String mobile) {
//
//        Employee e = empRepo.findByMobile(mobile);
//
//        System.out.println(e.getName());
//        System.out.println(e.getDepartment().getName());
//        System.out.println(e.getDepartment().getManagerName());
//    }
//}