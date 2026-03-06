package com.aditya.jobtracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

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
}
