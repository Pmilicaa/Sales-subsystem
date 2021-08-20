package com.salesSubsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesSubsystem.model.Company;
import com.salesSubsystem.repository.CompanyRepository;



public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}
	
	public Company getCompany(Long id) {
		return companyRepository.findById(id).get();
	}
	
	public Company saveCompany(Company company) {
		return companyRepository.save(company);
	}
	
	public void removeCompany(Company company) {
		//company.setActive(false);
		//companyRepository.save(company);
	}
	
}
