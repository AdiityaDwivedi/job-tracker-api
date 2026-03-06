package com.aditya.jobtracker.controller;

import com.aditya.jobtracker.entity.JobApplication;
import com.aditya.jobtracker.service.JobApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;


    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping
    public JobApplication createApplication(@RequestBody JobApplication application) {
        return jobApplicationService.createApplication(application);
    }

    @PutMapping("/{id}")
    public JobApplication updateApplication(@PathVariable Long id,
                                            @RequestBody JobApplication jobApplication) {
        return jobApplicationService.updateApplication(id, jobApplication);
    }

    @GetMapping
    public List<JobApplication> getAllApplications() {
        return jobApplicationService.getAllApplications();
    }

    @GetMapping("{id}")
    public JobApplication getApplicationsById(@PathVariable Long id) {
        return jobApplicationService.getApplicationById(id);
    }

    @DeleteMapping("{id}")
    public void deleteApplication(@PathVariable Long id) {
        jobApplicationService.deleteApplication(id);
    }

}
