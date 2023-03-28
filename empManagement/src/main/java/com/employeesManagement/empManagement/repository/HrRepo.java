package com.employeesManagement.empManagement.repository;

import com.employeesManagement.empManagement.entity.Hr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrRepo extends JpaRepository<Hr, Integer> {
}
