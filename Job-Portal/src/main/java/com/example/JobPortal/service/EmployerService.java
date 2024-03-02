package com.example.JobPortal.service;

import com.example.JobPortal.dto.EmployerDTO;
import com.example.JobPortal.entities.Employer;

import java.util.List;

public interface EmployerService {
    //Create a new Employer
    EmployerDTO createEmployer(EmployerDTO employer);
    //Get a employer
    EmployerDTO getEmployer(Long employerId);
    //Get all employers
    List<EmployerDTO> getAllEmployers();
    //Update particular employer
    EmployerDTO updateEmployer(Long employerId,EmployerDTO employerDTO);
    //Delete particular employee
    void deleteEmployer(Long employeeId);
}
