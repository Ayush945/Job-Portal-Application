package com.example.JobPortal.service.impl;

import com.example.JobPortal.dto.JobDTO;
import com.example.JobPortal.entities.Job;
import com.example.JobPortal.repository.JobRepo;
import com.example.JobPortal.service.JobService;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepo jobRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public JobDTO getJob(Long jobId) {
        return modelMapper.map(jobRepo.findById(jobId),JobDTO.class);
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> jobs=jobRepo.findAll();
        return  jobs.stream().map(job->modelMapper.map(jobs,JobDTO.class)).toList();
    }

    @Override
    public JobDTO addJob(JobDTO jobDTO) {
        Job job=jobRepo.save(modelMapper.map(jobDTO,Job.class));
        return modelMapper.map(job,JobDTO.class);
    }

    @Override
    public JobDTO updateJob(Long jobId, JobDTO jobDTO) {
        Job existingJob=jobRepo.findById(jobId)
                .orElseThrow(()->new RuntimeException("Job Not Found"));
        ModelMapper localModelMapper=new ModelMapper();
        TypeMap<JobDTO,Job>propertyMapper=localModelMapper.createTypeMap(JobDTO.class,Job.class);
        propertyMapper.addMappings(mapper->mapper.skip(JobDTO::getJobId,Job::setJobId));
        localModelMapper.getConfiguration().setPropertyCondition(mappingContext ->
        {
            if(mappingContext.getSource()==null){
                return false;
            }
           return true;
        });
        localModelMapper.map(jobDTO,existingJob);
        jobRepo.save(existingJob);
        return localModelMapper.map(existingJob,JobDTO.class);
    }

    @Override
    public void deleteJob(Long jobId) {
        jobRepo.deleteById(jobId);
    }
}
