package com.employeesManagement.empManagement.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class HrSaveDTO {
    private String hrName;
    private String hrEmail;
    private String hrAddress;

    private String hrPhone;

    private long hrSalary;


    public HrSaveDTO() {
    }

    public HrSaveDTO(String hrName, String hrEmail, String hrAddress, String hrPhone, long hrSalary) {
        this.hrName = hrName;
        this.hrEmail = hrEmail;
        this.hrAddress = hrAddress;
        this.hrPhone = hrPhone;
        this.hrSalary = hrSalary;
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
}
