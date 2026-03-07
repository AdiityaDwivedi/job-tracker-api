package com.aditya.jobtracker.service;

import com.aditya.jobtracker.DTO.JobApplicationDTO;
import com.aditya.jobtracker.entity.JobApplication;

import java.util.List;

public interface JobApplicationService {

    JobApplication createApplication(JobApplication jobApplication);

    List<JobApplicationDTO> getAllApplications();

    JobApplicationDTO getApplicationById(Long id);

    void deleteApplication(Long id);

    JobApplication updateApplication(Long id, JobApplication jobApplication);

}
