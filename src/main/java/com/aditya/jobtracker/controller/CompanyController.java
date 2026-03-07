package com.aditya.jobtracker.controller;

import com.aditya.jobtracker.entity.Company;
import com.aditya.jobtracker.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public Company createCompany(@Valid @RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("{id}")
    public void deleteCompanyById(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }
}

























