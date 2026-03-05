package com.aditya.jobtracker.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Setter
@Getter
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    private String status;

    private String appliedDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Company company;

    public JobApplication() {}

    public JobApplication(String role, String status, User user, String appliedDate, Company company) {
        this.role = role;
        this.status = status;
        this.user = user;
        this.appliedDate = appliedDate;
        this.company = company;
    }

    JobApplication updateApplication(Long id, JobApplication jobApplication) {
        JobApplication existing = jobApplicationRepository.findById(id).orElse(null);

        if(existing != null) {
            existing.setRole(jobApplication.getRole());
            existing.setStatus(jobApplication.getStatus());
            existing.setAppliedDate((jobApplication.getAppliedDate()));
            return jobApplicationRepository.save(existing);
        }

        return null;
    }
}
