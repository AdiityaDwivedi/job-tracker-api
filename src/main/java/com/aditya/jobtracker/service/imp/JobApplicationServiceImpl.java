package com.aditya.jobtracker.service.imp;

import com.aditya.jobtracker.entity.JobApplication;
import com.aditya.jobtracker.repository.JobApplicationRepository;
import com.aditya.jobtracker.service.JobApplicationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public JobApplication createApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    @Override
    public List<JobApplication> getAllApplications() {
        return jobApplicationRepository.findAll();
    }

    @Override
    public JobApplication getApplicationById(Long id) {
        return jobApplicationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteApplication(Long id) {
        jobApplicationRepository.deleteById(id);
    }

    @Override
    public JobApplication updateApplication(Long id, JobApplication jobApplication) {

        JobApplication existing = jobApplicationRepository.findById(id).orElse(null);

        if(existing != null) {
            existing.setRole(jobApplication.getRole());
            existing.setStatus(jobApplication.getStatus());
            existing.setAppliedDate(jobApplication.getAppliedDate());

            return jobApplicationRepository.save(existing);
        }

        return null;
    }


}
