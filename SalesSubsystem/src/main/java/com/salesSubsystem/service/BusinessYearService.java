package com.salesSubsystem.service;

import java.util.List;

import com.salesSubsystem.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesSubsystem.model.BusinessYear;
import com.salesSubsystem.repository.BusinessYearRepository;

@Service
public class BusinessYearService {

	@Autowired
	private BusinessYearRepository businessYearRepository;
	
	public List<BusinessYear> getAllBusinessYears() {
		return businessYearRepository.findAll();
	}
	
	public BusinessYear getBusinessYear(Long id) {
		return businessYearRepository.findById(id).get();
	}
	
	public BusinessYear saveBusinessYear(BusinessYear businessYear) {
		return businessYearRepository.save(businessYear);
	}

	public BusinessYear findCurrentYearByCompany(Company company){
		return businessYearRepository.findFirstByCompanyOrderByYearDesc(company);
	}

	public void removeBusinessYear(BusinessYear businesYear) {
		//businesYear.setActive(false);
		//businessYearRepository.save(businesYear);
	}
	
}
