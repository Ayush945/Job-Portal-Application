package com.example.JobPortal.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JobDTO {
    private Long jobId;
    private String jobName;
    private String experienceRequired;
    private String jobDetails;
    private String workingTime;
    private String skillsRequired;
    private String educationRequired;
}
