package com.example.JobPortal.controller;

import com.example.JobPortal.dto.AdminDTO;
import com.example.JobPortal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/get-admin/{adminId}")
    public ResponseEntity<AdminDTO> getAdmin(@PathVariable("adminId") Long adminId){
        return ResponseEntity.ok().body(adminService.getAdmin(adminId));
    }
    @PutMapping("/update-admin/{adminId}")
    public ResponseEntity<AdminDTO> updateAdmin(@PathVariable("adminId") Long adminId, @RequestBody AdminDTO adminDTO){
        return ResponseEntity.ok().body(adminService.updateAdmin(adminId,adminDTO));
    }
}
