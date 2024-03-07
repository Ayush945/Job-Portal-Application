package com.example.JobPortal.service;

import com.example.JobPortal.dto.AdminDTO;

public interface AdminService {
    AdminDTO getAdmin(Long adminId);
    AdminDTO updateAdmin(Long adminId,AdminDTO adminDTO);
}
