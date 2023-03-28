package com.employeesManagement.empManagement.controller;

import com.employeesManagement.empManagement.DTO.HrDTO;
import com.employeesManagement.empManagement.DTO.HrSaveDTO;
import com.employeesManagement.empManagement.DTO.HrUpdateDTO;
import com.employeesManagement.empManagement.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/hr")
public class HrController {
    @Autowired
    private HrService hrService;

    @PostMapping(path = "/save")
    public String saveHr(@RequestBody HrSaveDTO hrSaveDTO) {
        return hrService.addHr(hrSaveDTO);
    }

    @GetMapping(path = "/get")
    public List<HrDTO> getAllHr() {
        List<HrDTO> allHr = hrService.getAllHr();
        return allHr;
    }

    @PutMapping(path = "/update")
    public String updateHr(@RequestBody HrUpdateDTO hrUpdateDTO) {
        return hrService.updateHr(hrUpdateDTO);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteHr(@PathVariable(value = "id") int id) {
        boolean deleteHr = hrService.deleteHr(id);
        return "deleted";
    }
}
