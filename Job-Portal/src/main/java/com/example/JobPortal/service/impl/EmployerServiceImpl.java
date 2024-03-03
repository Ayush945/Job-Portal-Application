package com.example.JobPortal.service.impl;

import com.example.JobPortal.dto.EmployerDTO;
import com.example.JobPortal.entities.Employer;
import com.example.JobPortal.repository.EmployerRepo;
import com.example.JobPortal.service.EmployerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployerRepo employerRepo;

    @Override
    public EmployerDTO createEmployer(EmployerDTO employer) {
        Employer newEmployer=modelMapper.map(employer,Employer.class);
        employerRepo.save(newEmployer);
        return employer;
    }

    @Override
    public EmployerDTO getEmployer(Long employerId) {
        Employer employer=employerRepo.findById(employerId)
                .orElseThrow(()->new RuntimeException("Employer not found"));
        EmployerDTO employerDTO=modelMapper.map(employer,EmployerDTO.class);
        return employerDTO;
    }

    @Override
    public List<EmployerDTO> getAllEmployers() {
        List<Employer> employers=employerRepo.findAll();
        List<EmployerDTO> employerDTOS=employers.stream().
                map(employer -> modelMapper.
                        map(employer,EmployerDTO.class)).
                collect(Collectors.toList());
        return employerDTOS;
    }

    @Override
    public EmployerDTO updateEmployer(Long employerId,EmployerDTO employerDTO) {
        Employer savedEmployer=employerRepo.findById(employerId)
                .orElseThrow(()->new RuntimeException("Employer not found"));
        Employer newEmployer=modelMapper.map(employerDTO,Employer.class);
        if(!newEmployer.getEmail().isEmpty()){
            savedEmployer.setEmail(newEmployer.getEmail());
        }
        if(!newEmployer.getFullName().isEmpty()){
            savedEmployer.setFullName(newEmployer.getFullName());
        }

        employerRepo.save(savedEmployer);

        return modelMapper.map(savedEmployer,EmployerDTO.class);
    }

    @Override
    public void deleteEmployer(Long employeeId) {
        employerRepo.deleteById(employeeId);
    }
}
