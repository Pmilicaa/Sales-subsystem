package com.salesSubsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesSubsystem.model.BusinessPartner;
import com.salesSubsystem.repository.BusinessPartnerRepository;


public class BusinessPartnerService {

	@Autowired
	private BusinessPartnerRepository businessPartnerRepository;
	
	public List<BusinessPartner> getAllBusinessPartners() {
		return businessPartnerRepository.findAll();
	}
	
	public BusinessPartner getBusinessPartner(Long id) {
		return businessPartnerRepository.findById(id).get();
	}
	
	public BusinessPartner saveBusinessPartner(BusinessPartner businesPartner) {
		return businessPartnerRepository.save(businesPartner);
	}
	
	public void removeBusinessPartner(BusinessPartner businessPartner) {
		//businessPartner.setActive(false);
		//businessPartnerRepository.save(businessPartner);
	}
	
}
