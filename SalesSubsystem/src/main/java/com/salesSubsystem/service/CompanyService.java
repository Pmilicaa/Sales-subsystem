package com.salesSubsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesSubsystem.model.Company;
import com.salesSubsystem.repository.CompanyRepository;


@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}
	
	public Company getCompany(Long id) {
		return companyRepository.findById(id).get();
	}

	public Company getCompanyByPib(long pib) {
		return companyRepository.findByPIB(pib);
	}

	public Company saveCompany(Company company) {
		return companyRepository.save(company);
	}

	public Company findByPriceListsId(long priceListId){
		return companyRepository.findByPriceLists_Id(priceListId);
	}
	
	public void removeCompany(Company company) {
		//company.setActive(false);
		//companyRepository.save(company);
	}
	
}
