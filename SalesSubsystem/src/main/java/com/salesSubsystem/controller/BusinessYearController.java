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

import com.salesSubsystem.model.BusinessYear;
import com.salesSubsystem.service.BusinessYearService;

@RestController
public class BusinessYearController {

	@Autowired
	private BusinessYearService businessYearService;
	
	@GetMapping(path = "/businessyears")
	public @ResponseBody ResponseEntity<?> getAllBusinessYears() {
		return new ResponseEntity(businessYearService.getAllBusinessYears(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/businessyears/{businessYearId}")
	public ResponseEntity<?> getBusinessYear(@PathVariable("businessYearId") Long businessYearId) {
		BusinessYear businessYear = businessYearService.getBusinessYear(businessYearId);
		if(businessYear == null) {
			return new ResponseEntity<BusinessYear>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(businessYear, HttpStatus.OK);
	}
	
	@PostMapping(path = "/businessyears")
	public @ResponseBody ResponseEntity<?> saveBusinessYear(@RequestBody BusinessYear businessYear) {
		BusinessYear newBusinessYear = businessYearService.saveBusinessYear(businessYear);
		return new ResponseEntity(newBusinessYear, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/businessyears/{businessYearId}")
	public ResponseEntity<Void> deleteBusinessYear(@PathVariable("businessYearId") Long businessYearId) {
		BusinessYear businessYear = businessYearService.getBusinessYear(businessYearId);
		if(businessYear == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		businessYearService.removeBusinessYear(businessYear);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
