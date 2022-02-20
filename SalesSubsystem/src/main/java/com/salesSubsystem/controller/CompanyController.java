package com.salesSubsystem.controller;

import com.salesSubsystem.dto.CompanyDto;
import com.salesSubsystem.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesSubsystem.model.Company;
import com.salesSubsystem.service.CompanyService;

import java.util.Optional;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@GetMapping(path = "/companies")
	public @ResponseBody ResponseEntity<?> getAllCompanies() {
		return new ResponseEntity(companyService.getAllCompanies(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@GetMapping(path = "/companies/{companyId}")
	public ResponseEntity<?> getCompany(@PathVariable("companyId") Long companyId) {
		Company company = companyService.getCompany(companyId);
		if(company == null) {
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(company, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@PostMapping(path = "/companies")
	public @ResponseBody ResponseEntity<?> saveCompany(@RequestBody CompanyDto companyDto) {
		Company company = companyService.getCompanyByPib(companyDto.getPib());
		if(company == null){
			Company newCompany = companyService.saveCompany(new Company(companyDto));
			return new ResponseEntity(newCompany, HttpStatus.OK);
		}else{
			return new ResponseEntity(new Message("Company with the same PIB already exists"), HttpStatus.BAD_REQUEST);
		}
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
