package com.employeesManagement.empManagement.controller;

import com.employeesManagement.empManagement.DTO.EmployeeDTO;
import com.employeesManagement.empManagement.DTO.EmployeeSaveDTO;
import com.employeesManagement.empManagement.DTO.EmployeeUpdateDTO;
import com.employeesManagement.empManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO) {
        return employeeService.addEmployee(employeeSaveDTO);
    }

    @GetMapping(path = "/get")
    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeDTO> allCustomers = employeeService.getAllEmployee();
        return allCustomers;
    }

    @GetMapping(path = "/get/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        return employee;
    }


    @PutMapping(path = "/update/{employeeId}")
    public String updateEmployee(@PathVariable int employeeId, @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        return employeeService.updateEmployee(employeeId, employeeUpdateDTO);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id) {
        boolean deletecustomer = employeeService.deleteEmployee(id);
        return "deleted";
    }
}
