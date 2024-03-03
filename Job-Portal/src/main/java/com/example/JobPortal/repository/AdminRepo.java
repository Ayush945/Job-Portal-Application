package com.example.JobPortal.repository;

import com.example.JobPortal.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,Long> {
    Optional<Admin> findByUsername(String username);

    Optional<Admin> findByEmail(String email);
}
