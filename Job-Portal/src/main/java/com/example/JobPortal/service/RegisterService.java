package com.example.JobPortal.service;

import com.example.JobPortal.dto.EmployerDTO;
import com.example.JobPortal.dto.JobSeekerDTO;
import com.example.JobPortal.dto.LoginRequestDTO;
import com.example.JobPortal.dto.LoginResponseDTO;

public interface RegisterService {
    JobSeekerDTO registerAsJobSeeker(JobSeekerDTO jobSeekerDTO);
    EmployerDTO registerAsEmployee(EmployerDTO employerDTO);
    void createAdmin();
}
