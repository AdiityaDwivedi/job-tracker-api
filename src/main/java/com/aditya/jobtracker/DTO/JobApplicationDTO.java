package com.aditya.jobtracker.DTO;

import com.aditya.jobtracker.entity.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationDTO {

    private Long id;
    private String role;
    private ApplicationStatus status;
    private String appliedDate;
    private Long userId;
    private Long companyId;

}
