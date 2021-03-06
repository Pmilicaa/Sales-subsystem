package com.salesSubsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesSubsystem.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
     Company findByPIB(long pib);
     Company findByPriceLists_Id(long priceListId);
}
