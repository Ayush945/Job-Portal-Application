package com.example.JobPortal.service;

import com.example.JobPortal.dto.LoginRequestDTO;
import com.example.JobPortal.dto.LoginResponseDTO;

public interface LoginService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
