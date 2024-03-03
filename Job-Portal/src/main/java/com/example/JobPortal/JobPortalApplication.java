package com.example.JobPortal;

import com.example.JobPortal.service.AuthenticationService;
import com.example.JobPortal.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobPortalApplication implements CommandLineRunner {
	@Autowired
	private RegisterService registerService;

	public static void main(String[] args) {
		SpringApplication.run(JobPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		registerService.createAdmin();
	}
}
