package com.salesSubsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesSubsystem.model.BusinessPartner;
import com.salesSubsystem.service.BusinessPartnerService;

@RestController
public class BusinessPartnerController {

	@Autowired 
	private BusinessPartnerService businessPartnerService;
	
	@GetMapping(path = "/businesspartners")
	public @ResponseBody ResponseEntity<?> getAllBusinessPartners() {
		return new ResponseEntity(businessPartnerService.getAllBusinessPartners(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/businesspartners/{businessPartnerId}")
	public ResponseEntity<?> getBusinessPartner(@PathVariable("businessPartnerId") Long businessPartnerId) {
		BusinessPartner businessPartner = businessPartnerService.getBusinessPartner(businessPartnerId);
		if(businessPartner == null) {
			return new ResponseEntity<BusinessPartner>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(businessPartner, HttpStatus.OK);
	}
	
	@PostMapping(path = "/businesspartners")
	public @ResponseBody ResponseEntity<?> saveBusinessPartner(@RequestBody BusinessPartner businessPartner) {
		BusinessPartner newBusinessPartner = businessPartnerService.saveBusinessPartner(businessPartner);
		return new ResponseEntity(newBusinessPartner, HttpStatus.OK);
	}
	
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
