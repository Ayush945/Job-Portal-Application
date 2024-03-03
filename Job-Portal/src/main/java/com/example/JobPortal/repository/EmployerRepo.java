package com.example.JobPortal.repository;

import com.example.JobPortal.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepo extends JpaRepository<Employer,Long> {
    Optional<Employer> findByUsername(String username);

    Optional<Employer> findByEmail(String email);
}
