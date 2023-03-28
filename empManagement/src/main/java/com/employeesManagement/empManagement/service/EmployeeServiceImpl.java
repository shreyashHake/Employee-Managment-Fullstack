package com.employeesManagement.empManagement.service;

import com.employeesManagement.empManagement.DTO.EmployeeDTO;
import com.employeesManagement.empManagement.DTO.EmployeeSaveDTO;
import com.employeesManagement.empManagement.DTO.EmployeeUpdateDTO;
import com.employeesManagement.empManagement.entity.Employee;
import com.employeesManagement.empManagement.errorHandler.ResourceNotFoundException;
import com.employeesManagement.empManagement.repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String addEmployee(EmployeeSaveDTO employeeSaveDTO) {
        Employee employee = new Employee(
                employeeSaveDTO.getEmployeeName(),
                employeeSaveDTO.getEmployeeEmail(),
                employeeSaveDTO.getEmployeeAddress(),
                employeeSaveDTO.getEmployeePhone(),
                employeeSaveDTO.getEmployeeSalary(),
                employeeSaveDTO.getEmployeeHr()
        );

        employeeRepo.save(employee);
        return employee.getEmployeeName();
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> getEmployee = employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (Employee employee: getEmployee) {
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    employee.getEmployeeId(),
                    employee.getEmployeeName(),
                    employee.getEmployeeEmail(),
                    employee.getEmployeeAddress(),
                    employee.getEmployeePhone(),
                    employee.getEmployeeSalary(),
                    employee.getEmployeeHr()
            );

            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        return new EmployeeDTO(employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeEmail(), employee.getEmployeeAddress(), employee.getEmployeePhone(), employee.getEmployeeSalary(),employee.getEmployeeHr());
    }



    @Override
    public String updateEmployee(int employeeId, EmployeeUpdateDTO employeeUpdateDTO) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setEmployeeName(employeeUpdateDTO.getEmployeeName());
            employee.setEmployeeEmail(employeeUpdateDTO.getEmployeeEmail());
            employee.setEmployeeAddress(employeeUpdateDTO.getEmployeeAddress());
            employee.setEmployeePhone(employeeUpdateDTO.getEmployeePhone());
            employee.setEmployeeSalary(employeeUpdateDTO.getEmployeeSalary());
            employee.setEmployeeHr(employeeUpdateDTO.getEmployeeHr());
            employeeRepo.save(employee);
            return "Employee updated successfully with id " + employeeId;
        } else {
            throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
        }
    }

    @Override
    public boolean deleteEmployee(int id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
        } else {
            System.out.println("Customer Not found");
        }
        return true;
    }
}
