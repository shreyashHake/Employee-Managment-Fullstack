package com.employeesManagement.empManagement.service;

import com.employeesManagement.empManagement.DTO.*;

import java.util.List;

public interface HrService {
    String addHr(HrSaveDTO hrSaveDTO);

    List<HrDTO> getAllHr();

    String updateHr(HrUpdateDTO hrUpdateDTO);

    boolean deleteHr(int id);
}
