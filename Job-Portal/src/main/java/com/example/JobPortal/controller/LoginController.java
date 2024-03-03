package com.example.JobPortal.controller;

import com.example.JobPortal.dto.LoginRequestDTO;
import com.example.JobPortal.dto.LoginResponseDTO;
import com.example.JobPortal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO>login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok().body(loginService.login(loginRequestDTO));
    }

}
