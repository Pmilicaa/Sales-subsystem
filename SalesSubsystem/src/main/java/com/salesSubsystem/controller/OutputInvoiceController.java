package com.salesSubsystem.controller;

import com.salesSubsystem.dto.AddInvoiceDto;
import com.salesSubsystem.model.OutputInvoice;
import com.salesSubsystem.service.ArticleService;
import com.salesSubsystem.service.InvoiceItemService;
import com.salesSubsystem.service.OutputInvoiceService;
import com.salesSubsystem.service.PDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OutputInvoiceController {

	@Autowired
	private OutputInvoiceService outputInvoiceService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private InvoiceItemService invoiceItemService;

	@Autowired
	private PDVService pdvService;

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@GetMapping(path = "/outputInvoices")
	public @ResponseBody ResponseEntity<?> getAllOutputInvoices() {
		return new ResponseEntity(outputInvoiceService.getAllOutputInvoices(), HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@GetMapping(path = "/outputInvoices/{id}")
	public ResponseEntity<?> getOutputInvoice(@PathVariable("id") Long id) {
		OutputInvoice outputInvoice = outputInvoiceService.getOutputInvoice(id);
		if(outputInvoice == null) {
			return new ResponseEntity<OutputInvoice>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(outputInvoice, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@PostMapping(path = "/outputInvoices")
	public @ResponseBody ResponseEntity<?> saveOutputInvoice(@RequestBody AddInvoiceDto addInvoiceDto) {
		OutputInvoice outputInvoice = outputInvoiceService.createInvoice(addInvoiceDto);
		OutputInvoice savedInvoice = outputInvoiceService.saveOutputInvoice(outputInvoice);
		return new ResponseEntity(savedInvoice, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/outputInvoices/{id}")
	public ResponseEntity<Void> deleteOutputInvoice(@PathVariable("id") Long id) {
		OutputInvoice outputInvoice = outputInvoiceService.getOutputInvoice(id);
		if(outputInvoice == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		outputInvoiceService.removeOutputInvoice(outputInvoice);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
