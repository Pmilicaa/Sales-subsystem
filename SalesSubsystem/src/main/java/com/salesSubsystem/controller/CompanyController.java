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

import com.salesSubsystem.model.Company;
import com.salesSubsystem.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping(path = "/companies")
	public @ResponseBody ResponseEntity<?> getAllCompanies() {
		return new ResponseEntity(companyService.getAllCompanies(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/companies/{companyId}")
	public ResponseEntity<?> getCompany(@PathVariable("companyId") Long companyId) {
		Company company = companyService.getCompany(companyId);
		if(company == null) {
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(company, HttpStatus.OK);
	}
	
	@PostMapping(path = "/companies")
	public @ResponseBody ResponseEntity<?> saveCompany(@RequestBody Company company) {
		Company newCompany = companyService.saveCompany(company);
		return new ResponseEntity(newCompany, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/companies/{companyId}")
	public ResponseEntity<Void> deleteCompany(@PathVariable("companyId") Long companyId) {
		Company company = companyService.getCompany(companyId);
		if(company == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		companyService.removeCompany(company);;
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
