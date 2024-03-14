package com.example.JobPortal.controller;

import com.example.JobPortal.dto.JobDTO;
import com.example.JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;
    @GetMapping("get-job/{jobId}")
    public ResponseEntity<JobDTO>getJob(@PathVariable("jobId") Long jobId){
        return ResponseEntity.ok().body(jobService.getJob(jobId));
    }
    @GetMapping("get-all-jobs")
    public ResponseEntity<List<JobDTO>>getAllJobs(){
        return ResponseEntity.ok().body(jobService.getAllJobs());
    }
    @PostMapping("add-job")
    public ResponseEntity<JobDTO>addJob(@RequestBody JobDTO jobDTO){
        return ResponseEntity.ok().body(jobService.addJob(jobDTO));
    }
    @PutMapping("update-job/{jobId}")
    public ResponseEntity<JobDTO>updateJob(@PathVariable("jobId")Long jobId, @RequestBody JobDTO jobDTO){
        return ResponseEntity.ok().body(jobService.updateJob(jobId,jobDTO));
    }
    @DeleteMapping("delete-job/{jobId}")
    public ResponseEntity<?> deleteJob(@PathVariable("jobId")Long jobId ){
        jobService.deleteJob(jobId);
        return ResponseEntity.noContent().build();//noContent -> 204 error
    }

}
