package com.example.Assignment8.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Assignment8.Dto.DepartmentWiseEmployeeDTO;
import com.example.Assignment8.Entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // 2. Fetch all employees with department
    @Query("SELECT e FROM Employee e JOIN FETCH e.department")
    List<Employee> getAllEmployeesWithDept();

    // 3. Count employees per department
    @Query("SELECT new com.example.Assignment8.Dto.DepartmentWiseEmployeeDTO( e.department.name, COUNT(e)) FROM Employee e GROUP BY e.department.name")
    List<DepartmentWiseEmployeeDTO> countEmployeesByDept();
    //@Query("SELECT e.department.name, COUNT(e) FROM Employee e GROUP BY e.department.name")
    //List<Object[]> countEmployeesByDept();
    

    // 4. Employees by department name
    List<Employee> findByDepartment_Name(String deptName);

    // 5. Find by mobile number
    @Query("SELECT e FROM Employee e JOIN e.mobileNumbers m WHERE m = :mobile")
    Employee findByMobile(@Param("mobile") String mobile);
}
