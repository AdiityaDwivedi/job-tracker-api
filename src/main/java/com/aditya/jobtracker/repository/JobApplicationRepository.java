package com.aditya.jobtracker.repository;

import com.aditya.jobtracker.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

}
