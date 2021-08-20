package com.salesSubsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesSubsystem.model.BusinessYear;
import com.salesSubsystem.repository.BusinessYearRepository;

public class BusinessYearService {

	@Autowired
	private BusinessYearRepository businessYearRepository;
	
	public List<BusinessYear> getAllBusinessYears() {
		return businessYearRepository.findAll();
	}
	
	public BusinessYear getBusinessYear(Long id) {
		return businessYearRepository.findById(id).get();
	}
	
	public BusinessYear saveBusinessYear(BusinessYear businesYear) {
		return businessYearRepository.save(businesYear);
	}
	
	public void removeBusinessYear(BusinessYear businesYear) {
		//businesYear.setActive(false);
		//businessYearRepository.save(businesYear);
	}
	
}
