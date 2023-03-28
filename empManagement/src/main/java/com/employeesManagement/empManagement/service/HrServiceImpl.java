package com.employeesManagement.empManagement.service;

import com.employeesManagement.empManagement.DTO.HrDTO;
import com.employeesManagement.empManagement.DTO.HrSaveDTO;
import com.employeesManagement.empManagement.DTO.HrUpdateDTO;
import com.employeesManagement.empManagement.entity.Hr;
import com.employeesManagement.empManagement.repository.HrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HrServiceImpl implements HrService{

    @Autowired
    private HrRepo hrRepo;

    @Override
    public String addHr(HrSaveDTO hrSaveDTO) {
        Hr hr = new Hr(
                hrSaveDTO.getHrName(),
                hrSaveDTO.getHrEmail(),
                hrSaveDTO.getHrAddress(),
                hrSaveDTO.getHrPhone(),
                hrSaveDTO.getHrSalary()
        );

        hrRepo.save(hr);
        return hr.getHrName();
    }

    @Override
    public List<HrDTO> getAllHr() {
        List<Hr> getHr = hrRepo.findAll();
        List<HrDTO> hrDTOList = new ArrayList<>();

        for (Hr hr: getHr) {
            HrDTO hrDTO = new HrDTO(
                    hr.getHrId(),
                    hr.getHrName(),
                    hr.getHrEmail(),
                    hr.getHrAddress(),
                    hr.getHrPhone(),
                    hr.getHrSalary()
            );

            hrDTOList.add(hrDTO);
        }
        return hrDTOList;
    }

    @Override
    public String updateHr(HrUpdateDTO hrUpdateDTO) {
        if (hrRepo.existsById(hrUpdateDTO.getHrId())) {
            Hr hr = hrRepo.getById(hrUpdateDTO.getHrId());

            hr.setHrName(hrUpdateDTO.getHrName());
            hr.setHrEmail(hrUpdateDTO.getHrEmail());
            hr.setHrAddress(hrUpdateDTO.getHrAddress());
            hr.setHrPhone(hrUpdateDTO.getHrPhone());
            hr.setHrSalary(hrUpdateDTO.getHrSalary());

            hrRepo.save(hr);

            return "Updated Successfully!";

        } else {
            System.out.println("Customer Id does not exits");
        }

        return null;
    }

    @Override
    public boolean deleteHr(int id) {
        if (hrRepo.existsById(id)) {
            hrRepo.deleteById(id);
        } else {
            System.out.println("Customer Not found");
        }
        return true;
    }
}
