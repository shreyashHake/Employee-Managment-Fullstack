package com.employeesManagement.empManagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "hrManager")
public class Hr {
    @Id
    @Column(name = "hr_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hrId;

    @Column(name = "hr_name", length = 50)
    private String hrName;
    @Column(name = "hr_email", length = 50)
    private String hrEmail;

    @Column(name = "hr_address", length = 50)
    private String hrAddress;

    @Column(name = "hr_phone", length = 12)
    private String hrPhone;

    @Column(name = "hr_salary", length = 15)
    private long hrSalary;

    public Hr() {
    }

    public Hr(String hrName, String hrEmail, String hrAddress, String hrPhone, long hrSalary) {
        this.hrName = hrName;
        this.hrEmail = hrEmail;
        this.hrAddress = hrAddress;
        this.hrPhone = hrPhone;
        this.hrSalary = hrSalary;
    }

    public Hr(int hrId, String hrName, String hrEmail, String hrAddress, String hrPhone, long hrSalary) {
        this.hrId = hrId;
        this.hrName = hrName;
        this.hrEmail = hrEmail;
        this.hrAddress = hrAddress;
        this.hrPhone = hrPhone;
        this.hrSalary = hrSalary;
    }

    public int getHrId() {
        return hrId;
    }

    public void setHrId(int hrId) {
        this.hrId = hrId;
    }

    public String getHrAddress() {
        return hrAddress;
    }

    public void setHrAddress(String hrAddress) {
        this.hrAddress = hrAddress;
    }

    public String getHrPhone() {
        return hrPhone;
    }

    public void setHrPhone(String hrPhone) {
        this.hrPhone = hrPhone;
    }

    public long getHrSalary() {
        return hrSalary;
    }

    public void setHrSalary(long hrSalary) {
        this.hrSalary = hrSalary;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public String getHrEmail() {
        return hrEmail;
    }

    public void setHrEmail(String hrEmail) {
        this.hrEmail = hrEmail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + hrId +
                ", employeeName='" + hrName + '\'' +
                ", employeeAddress='" + hrAddress + '\'' +
                ", employeePhone='" + hrPhone + '\'' +
                ", employeeSalary=" + hrSalary +
                '}';
    }
}
