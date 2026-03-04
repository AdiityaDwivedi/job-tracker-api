package com.aditya.jobtracker.service;

import com.aditya.jobtracker.entitiy.Company;

import java.util.List;

public interface CompanyService {

    Company createCompany(Company company);

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);
}
