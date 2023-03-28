package com.employeesManagement.empManagement.service;

import com.employeesManagement.empManagement.DTO.EmployeeDTO;
import com.employeesManagement.empManagement.DTO.EmployeeSaveDTO;
import com.employeesManagement.empManagement.DTO.EmployeeUpdateDTO;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeSaveDTO employeeSaveDTO);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO getEmployeeById(int id);

    String updateEmployee(int employeeId, EmployeeUpdateDTO employeeUpdateDTO);

    boolean deleteEmployee(int id);
}
