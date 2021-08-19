package com.salesSubsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesSubsystem.model.BusinessYear;

public interface BusinessYearRepository extends JpaRepository<BusinessYear, Long>{

}
