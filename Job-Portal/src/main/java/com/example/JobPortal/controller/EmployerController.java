package com.example.JobPortal.controller;

import com.example.JobPortal.dto.EmployerDTO;
import com.example.JobPortal.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employer")
@RestController
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping("/get-employer/{employerId}")
    public ResponseEntity<EmployerDTO> getEmployer(@PathVariable("employerId") Long employerId){
        return ResponseEntity.ok().body(employerService.getEmployer(employerId));
    }

    @GetMapping("/get-all-employers")
    public ResponseEntity<List<EmployerDTO>> getAllEmployers(){
        return ResponseEntity.ok().body(employerService.getAllEmployers());
    }

    @PostMapping("/create-employer")
    public ResponseEntity<EmployerDTO> createEmployer(@RequestBody EmployerDTO employerDTO){
        return ResponseEntity.ok().body(employerService.createEmployer(employerDTO));
    }
    @PutMapping("/update-employer/{employerId}")
    public ResponseEntity<EmployerDTO> updateEmployer(@PathVariable("employerId") Long employerId, @RequestBody EmployerDTO employerDTO){
        return ResponseEntity.ok().body(employerService.updateEmployer(employerId,employerDTO));
    }
    @DeleteMapping("/delete-employer/{employerId}")
    public void deleteEmployer(@PathVariable("employerId") Long employerId){
        employerService.deleteEmployer(employerId);
    }
}
