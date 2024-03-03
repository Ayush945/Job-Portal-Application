package com.example.JobPortal.service.impl;

import com.example.JobPortal.dto.*;
import com.example.JobPortal.entities.Admin;
import com.example.JobPortal.entities.Employer;
import com.example.JobPortal.entities.JobSeeker;
import com.example.JobPortal.entities.User;
import com.example.JobPortal.enums.RoleEnum;
import com.example.JobPortal.repository.AdminRepo;
import com.example.JobPortal.repository.EmployerRepo;
import com.example.JobPortal.repository.JobSeekerRepo;
import com.example.JobPortal.service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private JobSeekerRepo jobSeekerRepo;
    @Autowired
    private EmployerRepo employerRepo;

    @Override
    public UsernamePasswordAuthenticationToken getEmailPasswordAuthenticationToken(String email, RoleEnum role) {
        if(role.equals(RoleEnum.ROLE_JOB_SEEKER)){
           JobSeekerDTO jobSeekerDTO=getJobSeekerByEmail(email);
            List<SimpleGrantedAuthority> authorities=this.addAuthority(jobSeekerDTO.getRole());
            return new UsernamePasswordAuthenticationToken(jobSeekerDTO.getEmail(),jobSeekerDTO.getPassword(),authorities);
        }
        else if (role.equals(RoleEnum.ROLE_EMPLOYER)) {
            EmployerDTO employerDTO=getEmployerByEmail(email);
            List<SimpleGrantedAuthority>authorities=addAuthority(employerDTO.getRole());
            return new UsernamePasswordAuthenticationToken(employerDTO.getEmail(),employerDTO.getPassword(),authorities);
        }
        else {
            AdminDTO adminDTO=getAdminByEmail(email);
            List<SimpleGrantedAuthority>authorities=addAuthority(adminDTO.getRole());
            return new UsernamePasswordAuthenticationToken(adminDTO.getEmail(),adminDTO.getPassword(),authorities);
        }
    }


    public List<SimpleGrantedAuthority> addAuthority(RoleEnum role) {
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        if(Objects.nonNull(role)){
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return authorities;
    }

    public AdminDTO getAdminByEmail(String email) {
        Admin admin=adminRepo.findByEmail(email)
                .orElseThrow(()->new RuntimeException("User not found"));
        return modelMapper.map(admin,AdminDTO.class);
    }

    public EmployerDTO getEmployerByEmail(String email) {
        Employer employer =employerRepo.findByEmail(email)
                .orElseThrow(()->new RuntimeException("User not found"));
        return modelMapper.map(employer,EmployerDTO.class);
    }

    public JobSeekerDTO getJobSeekerByEmail(String email) {
        JobSeeker jobSeeker =jobSeekerRepo.findByEmail(email)
                .orElseThrow(()->new RuntimeException("User not found"));
        return modelMapper.map(jobSeeker,JobSeekerDTO.class);
    }


}
