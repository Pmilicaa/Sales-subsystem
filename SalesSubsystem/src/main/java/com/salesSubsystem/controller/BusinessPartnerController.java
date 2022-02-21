package com.salesSubsystem.controller;

import com.salesSubsystem.dto.BusinessPartnerDto;
import com.salesSubsystem.model.Company;
import com.salesSubsystem.model.OutputInvoice;
import com.salesSubsystem.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.salesSubsystem.model.BusinessPartner;
import com.salesSubsystem.service.BusinessPartnerService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BusinessPartnerController {

	@Autowired 
	private BusinessPartnerService businessPartnerService;

	@Autowired
	private CompanyService companyService;


	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@GetMapping(path = "/businesspartners")
	public @ResponseBody ResponseEntity<?> getAllBusinessPartners() {
		return new ResponseEntity(businessPartnerService.getAllBusinessPartners(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@GetMapping(path = "/businesspartners/{businessPartnerId}")
	public ResponseEntity<?> getBusinessPartner(@PathVariable("businessPartnerId") Long businessPartnerId) {
		BusinessPartner businessPartner = businessPartnerService.getBusinessPartner(businessPartnerId);
		if(businessPartner == null) {
			return new ResponseEntity<BusinessPartner>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(businessPartner, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@PostMapping(path = "/businesspartners")
	public @ResponseBody ResponseEntity<?> saveBusinessPartner(@RequestBody BusinessPartnerDto businessPartnerDto) {
		Company company = companyService.getCompanyByPib(businessPartnerDto.getPib());
 		BusinessPartner newBusinessPartner = new BusinessPartner(businessPartnerDto.getNamePartner(), businessPartnerDto.getAddress(), businessPartnerDto.getContact(),businessPartnerDto.geteMail(), businessPartnerDto.getPib(), company.getMIB(), true, company, new ArrayList<>());
		company.getBusinessPartners().add(newBusinessPartner);
		return new ResponseEntity(businessPartnerService.saveBusinessPartner(newBusinessPartner), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@DeleteMapping(path = "/businesspartners/{businessPartnerId}")
	public ResponseEntity<Void> deleteBusinessPartner(@PathVariable("businessPartnerId") Long businessPartnerId) {
		BusinessPartner businessPartner = businessPartnerService.getBusinessPartner(businessPartnerId);
		if(businessPartner == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		businessPartnerService.removeBusinessPartner(businessPartner);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
