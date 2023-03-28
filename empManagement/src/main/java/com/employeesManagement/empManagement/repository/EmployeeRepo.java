package com.employeesManagement.empManagement.repository;

import com.employeesManagement.empManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
