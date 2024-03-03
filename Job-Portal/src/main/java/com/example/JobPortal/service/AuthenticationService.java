package com.example.JobPortal.service;

import com.example.JobPortal.enums.RoleEnum;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthenticationService {
    UsernamePasswordAuthenticationToken getEmailPasswordAuthenticationToken(String username, RoleEnum role);

}
