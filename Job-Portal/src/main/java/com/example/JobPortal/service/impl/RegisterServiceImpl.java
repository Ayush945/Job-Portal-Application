package com.example.JobPortal.service.impl;

import com.example.JobPortal.dto.EmployerDTO;
import com.example.JobPortal.dto.JobSeekerDTO;
import com.example.JobPortal.entities.Admin;
import com.example.JobPortal.entities.Employer;
import com.example.JobPortal.entities.JobSeeker;
import com.example.JobPortal.repository.AdminRepo;
import com.example.JobPortal.repository.EmployerRepo;
import com.example.JobPortal.repository.JobSeekerRepo;
import com.example.JobPortal.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private JobSeekerRepo jobSeekerRepo;
    @Autowired
    private EmployerRepo employerRepo;
    @Override
    public JobSeekerDTO registerAsJobSeeker(JobSeekerDTO jobSeekerDTO) {
        JobSeeker jobSeeker=modelMapper.map(jobSeekerDTO,JobSeeker.class);
        if(usernameExists(jobSeeker.getUsername())){
            log.error("Username already exists",jobSeeker.getUsername());
            throw new RuntimeException("Username already exists");
        }
        jobSeeker.setPassword(passwordEncoder.encode(jobSeeker.getPassword()));
        jobSeeker.setAddress(jobSeeker.getAddress());
        jobSeeker.setEmail(jobSeeker.getEmail());
        jobSeeker.setFullName(jobSeeker.getFullName());
        jobSeeker.setContactNumber(jobSeeker.getContactNumber());
        jobSeeker.setUsername(jobSeeker.getUsername());
        jobSeekerRepo.save(jobSeeker);
        jobSeeker.setPassword(null);
        return modelMapper.map(jobSeeker, JobSeekerDTO.class);
    }

    @Override
    public EmployerDTO registerAsEmployee(EmployerDTO employerDTO) {
        Employer employer=modelMapper.map(employerDTO,Employer.class);
        if(usernameExists(employer.getUsername())){
            log.error("Username already exists",employer.getUsername());
            throw new RuntimeException("Username already exists");
        }
        employer.setPassword(passwordEncoder.encode(employer.getPassword()));
        employer.setAddress(employer.getAddress());
        employer.setEmail(employer.getEmail());
        employer.setFullName(employer.getFullName());
        employer.setContactNumber(employer.getContactNumber());
        employer.setUsername(employer.getUsername());
        employerRepo.save(employer);
        employer.setPassword(null);
        return modelMapper.map(employer,EmployerDTO.class);
    }

    @Override
    public void createAdmin() {
        Admin admin=new Admin();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setFullName("Ram Dhakal");
        admin.setEmail("Ramdhakal12@gmail.com");
        admin.setAddress("Koteshowr, Kathmandu");
        admin.setContactNumber("9867123120");
        adminRepo.save(admin);
    }
    private boolean usernameExists(String username) {
        Optional<Admin> savedAdmin=adminRepo.findByUsername(username);
        Optional<JobSeeker>savedCustomer=jobSeekerRepo.findByUsername(username);
        Optional<Employer>savedTrader=employerRepo.findByUsername(username);
        return savedTrader.isPresent()||savedAdmin.isPresent()||savedCustomer.isPresent();
    }
}
