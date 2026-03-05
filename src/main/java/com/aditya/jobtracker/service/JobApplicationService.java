package com.aditya.jobtracker.service;

import com.aditya.jobtracker.entity.JobApplication;

import java.util.List;

public interface JobApplicationService {

    JobApplication createApplication(JobApplication jobApplication);

    List<JobApplication> getAllApplications();

    JobApplication getApplicationById(Long id);

    void deleteApplication(Long id);

}
