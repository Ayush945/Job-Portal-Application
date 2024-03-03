package com.example.JobPortal.entities;

import com.example.JobPortal.enums.RoleEnum;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private final RoleEnum role=RoleEnum.ROLE_ADMIN;
}
