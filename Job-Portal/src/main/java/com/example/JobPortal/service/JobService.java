package com.example.JobPortal.service;

import com.example.JobPortal.dto.JobDTO;

import java.util.List;

public interface JobService {
    JobDTO getJob(Long jobId);
    List<JobDTO>getAllJobs();
    JobDTO addJob(JobDTO jobDTO);
    JobDTO updateJob(Long jobId,JobDTO jobDTO);
    void deleteJob(Long jobId);
}
