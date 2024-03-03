package com.example.JobPortal.controller;

import com.example.JobPortal.dto.EmployerDTO;
import com.example.JobPortal.dto.JobSeekerDTO;
import com.example.JobPortal.dto.LoginResponseDTO;
import com.example.JobPortal.entities.JobSeeker;
import com.example.JobPortal.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @PostMapping("/register-as-job-seeker")
    public ResponseEntity<JobSeekerDTO>registerAsJobSeeker(@RequestBody JobSeekerDTO jobSeekerDTO){
        return ResponseEntity.ok().body(registerService.registerAsJobSeeker(jobSeekerDTO));
    }
    @PostMapping("/register-as-employer")
    public ResponseEntity<EmployerDTO>registerAsEmployer(@RequestBody EmployerDTO employerDTO){
        return ResponseEntity.ok().body(registerService.registerAsEmployee(employerDTO));
    }
}
