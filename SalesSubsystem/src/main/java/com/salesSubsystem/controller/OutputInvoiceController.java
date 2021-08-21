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
import com.salesSubsystem.model.OutputInvoice;
import com.salesSubsystem.service.OutputInvoiceService;

@RestController
public class OutputInvoiceController {

	@Autowired
	private OutputInvoiceService outputInvoiceService;
	
	@GetMapping(path = "/outputinvoices")
	public @ResponseBody ResponseEntity<?> getAllOutputInvoices() {
		return new ResponseEntity(outputInvoiceService.getAllOutputInvoices(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/outputinvoices/{outputinvoiceId}")
	public ResponseEntity<?> getOutputInvoice(@PathVariable("outputinvoiceId") Long outputinvoiceId) {
		OutputInvoice outputInvoice = outputInvoiceService.getOutputInvoice(outputinvoiceId);
		if(outputInvoice == null) {
			return new ResponseEntity<OutputInvoice>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(outputInvoice, HttpStatus.OK);
	}
	
	@PostMapping(path = "/outputinvoices")
	public @ResponseBody ResponseEntity<?> saveOutputInvoice(@RequestBody OutputInvoice outputInvoice) {
		OutputInvoice newOutputInvoice = outputInvoiceService.saveOutputInvoice(outputInvoice);
		return new ResponseEntity(newOutputInvoice, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/outputinvoices/{outputinvoiceId}")
	public ResponseEntity<Void> deleteOutputInvoice(@PathVariable("outputinvoiceId") Long outputinvoiceId) {
		OutputInvoice outputInvoice = outputInvoiceService.getOutputInvoice(outputinvoiceId);
		if(outputInvoice == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		outputInvoiceService.removeOutputInvoice(outputInvoice);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
