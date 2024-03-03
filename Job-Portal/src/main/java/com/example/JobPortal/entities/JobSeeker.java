package com.example.JobPortal.entities;

import com.example.JobPortal.enums.RoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeeker extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobSeekerId;
    private final RoleEnum role=RoleEnum.ROLE_JOB_SEEKER;
}
