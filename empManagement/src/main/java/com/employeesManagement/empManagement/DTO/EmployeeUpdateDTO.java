package com.employeesManagement.empManagement.DTO;

public class EmployeeUpdateDTO {
    private int employeeId;

    private String employeeName;
    private String employeeEmail;
    private String employeeAddress;

    private String employeePhone;

    private long employeeSalary;

    private String employeeHr;

    public EmployeeUpdateDTO() {
    }

    public EmployeeUpdateDTO(int employeeId, String employeeName, String employeeEmail, String employeeAddress, String employeePhone, long employeeSalary, String employeeHr) {
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    @Override
    public String toString() {
        return "EmployeeUpdateDTO{" +
                "employeeId=" + employeeId +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeHr='" + employeeHr + '\'' +
                '}';
    }
}
