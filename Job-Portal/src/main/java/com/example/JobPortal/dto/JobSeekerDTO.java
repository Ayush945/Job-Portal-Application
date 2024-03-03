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
public class JobSeekerDTO extends UserDTO {
    private Long jobSeekerId;
    private final RoleEnum role=RoleEnum.ROLE_JOB_SEEKER;
}
