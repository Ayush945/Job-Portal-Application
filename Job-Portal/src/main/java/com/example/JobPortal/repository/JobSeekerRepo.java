package com.example.JobPortal.repository;

import com.example.JobPortal.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobSeekerRepo extends JpaRepository<JobSeeker,Long> {
    Optional<JobSeeker> findByUsername(String username);

    Optional<JobSeeker> findByEmail(String email);
}
