package com.example.JobPortal.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String fullName;
    private String password;
    private String address;
    private String email;
    private String contactNumber;
}
