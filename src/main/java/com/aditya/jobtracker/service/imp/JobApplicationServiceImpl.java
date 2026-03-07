package com.aditya.jobtracker.service.imp;

import com.aditya.jobtracker.DTO.JobApplicationDTO;
import com.aditya.jobtracker.entity.JobApplication;
import com.aditya.jobtracker.exception.ResourceNotFoundException;
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
    public List<JobApplicationDTO> getAllApplications() {
        return jobApplicationRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public JobApplicationDTO getApplicationById(Long id) {

        JobApplication application = jobApplicationRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));

        return convertToDTO(application);
    }

    @Override
    public void deleteApplication(Long id) {
        jobApplicationRepository.deleteById(id);
    }

    @Override
    public JobApplication updateApplication(Long id, JobApplication jobApplication) {

        JobApplication existing = jobApplicationRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));

        existing.setRole(jobApplication.getRole());
        existing.setStatus(jobApplication.getStatus());
        existing.setAppliedDate(jobApplication.getAppliedDate());

        return jobApplicationRepository.save(existing);
    }

    private JobApplicationDTO convertToDTO(JobApplication application) {
        return new JobApplicationDTO(
                application.getId(),
                application.getRole(),
                application.getStatus(),
                application.getAppliedDate(),
                application.getUser() != null ? application.getUser().getId() : null,
                application.getCompany() != null ? application.getCompany().getId() : null
        );
    }
}
