package com.example.Assignment8.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Assignment8.Entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
