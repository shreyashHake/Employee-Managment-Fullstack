package com.employeesManagement.empManagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    @Column(name = "employee_name", length = 50)
    private String employeeName;
    @Column(name = "employee_email", length = 50)
    private String employeeEmail;

    @Column(name = "employee_address", length = 50)
    private String employeeAddress;

    @Column(name = "employee_phone", length = 12)
    private String employeePhone;

    @Column(name = "employee_salary", length = 15)
    private long employeeSalary;

    @Column(name = "employee_hr", length = 50)
    private String employeeHr;

    public Employee() {
    }

    public Employee(String employeeName,String employeeEmail, String employeeAddress, String employeePhone, long employeeSalary, String employeeHr) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
        this.employeeSalary = employeeSalary;
        this.employeeHr = employeeHr;
    }

    public Employee(int employeeId, String employeeName,String employeeEmail, String employeeAddress, String employeePhone, long employeeSalary, String employeeHr) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
        this.employeeSalary = employeeSalary;
        this.employeeHr = employeeHr;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeHr() {
        return employeeHr;
    }

    public void setEmployeeHr(String employeeHr) {
        this.employeeHr = employeeHr;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeHr='" + employeeHr + '\'' +
                '}';
    }
}
