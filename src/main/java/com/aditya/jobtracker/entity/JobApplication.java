package com.aditya.jobtracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String role;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    private String appliedDate;

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private Company company;

    public JobApplication() {}

    public JobApplication(String role, ApplicationStatus status, User user, String appliedDate, Company company) {
        this.role = role;
        this.status = status;
        this.user = user;
        this.appliedDate = appliedDate;
        this.company = company;
    }
}
