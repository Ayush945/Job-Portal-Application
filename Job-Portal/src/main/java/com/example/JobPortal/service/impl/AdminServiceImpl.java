package com.example.JobPortal.service.impl;

import com.example.JobPortal.dto.AdminDTO;
import com.example.JobPortal.dto.EmployerDTO;
import com.example.JobPortal.entities.Admin;
import com.example.JobPortal.entities.Employer;
import com.example.JobPortal.repository.AdminRepo;
import com.example.JobPortal.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AdminDTO getAdmin(Long adminId) {
        Admin admin=adminRepo.findById(adminId)
                .orElseThrow(()->new RuntimeException("Admin not found"));
        AdminDTO adminDTO=modelMapper.map(admin,AdminDTO.class);
        return adminDTO;
    }

    @Override
    public AdminDTO updateAdmin(Long adminId, AdminDTO adminDTO) {
        Admin admin=adminRepo.findById(adminId)
                .orElseThrow(()->new RuntimeException("Admin not found"));
        Admin newAdmin=modelMapper.map(adminDTO,Admin.class);
        if(!newAdmin.getEmail().isEmpty()){
            admin.setEmail(newAdmin.getEmail());
        }
        if(!newAdmin.getFullName().isEmpty()){
            admin.setFullName(newAdmin.getFullName());
        }

        adminRepo.save(admin);

        return modelMapper.map(admin,AdminDTO.class);
    }
}
