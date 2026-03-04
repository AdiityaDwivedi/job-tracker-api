package com.aditya.jobtracker.repository;

import com.aditya.jobtracker.entitiy.Company;
import com.aditya.jobtracker.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
