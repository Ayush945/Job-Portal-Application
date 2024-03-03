package com.example.JobPortal.service.impl;

import com.example.JobPortal.dto.*;
import com.example.JobPortal.entities.Admin;
import com.example.JobPortal.entities.Employer;
import com.example.JobPortal.entities.JobSeeker;
import com.example.JobPortal.enums.RoleEnum;
import com.example.JobPortal.repository.AdminRepo;
import com.example.JobPortal.repository.EmployerRepo;
import com.example.JobPortal.repository.JobSeekerRepo;
import com.example.JobPortal.service.AuthenticationService;
import com.example.JobPortal.service.LoginService;
import com.example.JobPortal.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private EmployerRepo employerRepo;
    @Autowired
    private JobSeekerRepo jobSeekerRepo;
    @Autowired
    private AuthenticationServiceImpl authenticationServiceImpl;
    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        String email=loginRequestDTO.getEmail();
        String password=loginRequestDTO.getPassword();

        Optional<Admin> admin=adminRepo.findByEmail(email);
        Optional<JobSeeker> jobSeeker=jobSeekerRepo.findByEmail(email);
        Optional<Employer>employer=employerRepo.findByEmail(email);
        if(jobSeeker.isPresent()){

            return loginAsJobSeeker(email,password);
        } else if (admin.isPresent()) {
            return loginAsAdmin(email,password);
        } else if (employer.isPresent()) {
            return loginAsEmployer(email,password);
        }
        else {
            throw new RuntimeException("User not found");
        }
    }
    private LoginResponseDTO loginAsJobSeeker(String email,String password){
        JobSeekerDTO jobSeekerDTO=authenticationServiceImpl.getJobSeekerByEmail(email);
        return authenticate(jobSeekerDTO,password,jobSeekerDTO.getRole());
    }
    private LoginResponseDTO loginAsEmployer(String email,String password){
        EmployerDTO employerDTO=authenticationServiceImpl.getEmployerByEmail(email);
        return authenticate(employerDTO,password,employerDTO.getRole());
    }
    private LoginResponseDTO loginAsAdmin(String email,String password){
        AdminDTO adminDTO=authenticationServiceImpl.getAdminByEmail(email);
        return authenticate(adminDTO,password,adminDTO.getRole());
    }

    private LoginResponseDTO authenticate(UserDTO userDTO, String rawPassword, RoleEnum role) throws UsernameNotFoundException {
        checkPassword(rawPassword,userDTO.getPassword());
        List<SimpleGrantedAuthority> authorities=authenticationServiceImpl.addAuthority(role);
        Authentication usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDTO.getEmail(),
                userDTO.getPassword(),authorities);
        String accessToken=jwtUtil.generateToken(usernamePasswordAuthenticationToken.getName()
        ,generateRoles(usernamePasswordAuthenticationToken.getAuthorities()));
        userDTO.setPassword(null);
        return new LoginResponseDTO(accessToken,userDTO);
    }
    private void checkPassword(String rawPassword, String encodedPassword) {
        if(!passwordEncoder.matches(rawPassword,encodedPassword))
            throw new BadCredentialsException("PasswordIncorrect");
    }
    private List<String> generateRoles(Collection<? extends GrantedAuthority> authorities) {
        List<String>roles=new ArrayList<>();
        authorities.forEach(grantedAuthority -> roles.add(grantedAuthority.toString()))
        ;
        return roles;
    }

}
