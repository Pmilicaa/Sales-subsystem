package com.salesSubsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesSubsystem.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
