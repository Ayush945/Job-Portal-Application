package com.example.JobPortal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployerDTO {
    private Long employerId;
    private String employerName;
    private String employerEmail;
}
