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

import com.salesSubsystem.model.InvoiceItem;
import com.salesSubsystem.service.InvoiceItemService;

@RestController
public class InvoiceItemController {

	@Autowired
	private InvoiceItemService invoiceItemService;
	
	@GetMapping(path = "/invoiceitems")
	public @ResponseBody ResponseEntity<?> getAllInoviceItems() {
		return new ResponseEntity(invoiceItemService.getAllInvoiceItems(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/invoiceitems/{invoiceitemId}")
	public ResponseEntity<?> getInvoiceItem(@PathVariable("invoiceitemId") Long invoiceitemId) {
		InvoiceItem invoiceItem = invoiceItemService.getInoviceItem(invoiceitemId);
		if(invoiceItem == null) {
			return new ResponseEntity<InvoiceItem>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(invoiceItem, HttpStatus.OK);
	}
	
	@PostMapping(path = "/invoiceitems")
	public @ResponseBody ResponseEntity<?> saveInvoiceItem(@RequestBody InvoiceItem invoiceItem) {
		InvoiceItem newInvoiceItem = invoiceItemService.saveInoviceItem(invoiceItem);
		return new ResponseEntity(newInvoiceItem, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/invoiceitems/{invoiceitemId}")
	public ResponseEntity<Void> deleteInvoiceItem(@PathVariable("invoiceitemId") Long invoiceitemId) {
		InvoiceItem invoiceItem = invoiceItemService.getInoviceItem(invoiceitemId);
		if(invoiceItem == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		invoiceItemService.removeInvoiceItem(invoiceItem);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
