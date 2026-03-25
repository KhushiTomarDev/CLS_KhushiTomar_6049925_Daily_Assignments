package com.example.Assignment8.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assignment8.Dto.DepartmentWiseEmployeeDTO;
import com.example.Assignment8.Entities.Employee;
import com.example.Assignment8.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // ✅ 1. Insert Employee
    @PostMapping("/add/{deptId}")
    public String addEmployee(@RequestBody Employee e,
                              @PathVariable int deptId) {

        service.insertEmployee(e, deptId);
        return "Employee Added Successfully";
    }

    // ✅ 2. Fetch all employees with department
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // ✅ 3. Count employees per department
    @GetMapping("/count")
    public List<DepartmentWiseEmployeeDTO> countByDept() {
        return service.countByDept();
    }

    // ✅ 4. Employees by department name
    @GetMapping("/dept/{name}")
    public List<Employee> getByDept(@PathVariable String name) {
        return service.getByDeptName(name);
    }

    // ✅ 5. Find by mobile number
    @GetMapping("/mobile/{num}")
    public Employee getByMobile(@PathVariable String num) {
        return service.getByMobile(num);
    }
    @PutMapping("/update/{id}/{deptId}")
    public String updateEmployee(@PathVariable int id,
                                 @PathVariable int deptId,
                                 @RequestBody Employee e) {

        service.updateEmployee(id, deptId, e);
        return "Employee Updated Successfully";
    }
}