package com.aditya.jobtracker.repository;

import com.aditya.jobtracker.entitiy.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
