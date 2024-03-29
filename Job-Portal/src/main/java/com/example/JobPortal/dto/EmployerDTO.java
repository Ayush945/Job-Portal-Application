package com.example.JobPortal.dto;

import com.example.JobPortal.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployerDTO extends UserDTO {
    private Long employerId;
    private final RoleEnum role=RoleEnum.ROLE_EMPLOYER;
}
