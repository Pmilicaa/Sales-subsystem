package com.salesSubsystem.controller;

import com.salesSubsystem.dto.InvoiceItemDto;
import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.InvoiceItem;
import com.salesSubsystem.service.ArticleService;
import com.salesSubsystem.service.InvoiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class InvoiceItemController {

	@Autowired
	private InvoiceItemService invoiceItemService;

	@Autowired
	private ArticleService articleService;

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@GetMapping(path = "/invoiceItems")
	public @ResponseBody ResponseEntity<?> getAllInvoiceItems() {
		return new ResponseEntity(invoiceItemService.getAllInvoiceItems(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@GetMapping(path = "/invoiceItems/{id}")
	public ResponseEntity<?> getInvoiceItem(@PathVariable("id") Long id) {
		InvoiceItem invoiceItem = invoiceItemService.getInoviceItem(id);
		if(invoiceItem == null) {
			return new ResponseEntity<InvoiceItem>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(invoiceItem, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@PostMapping(path = "/invoiceItems")
	public @ResponseBody ResponseEntity<?> saveInvoiceItem(@RequestBody InvoiceItemDto invoiceItem) {
		Article article = articleService.getArticle(invoiceItem.getArticleId());
		InvoiceItem newInvoiceItem = new InvoiceItem(UUID.randomUUID().toString(), invoiceItem.getAmount(),
				invoiceItem.getDiscount(), invoiceItem.getUnitPrice(), invoiceItem.getBase(), invoiceItem.getPercentagePDV(),
				invoiceItem.getTotal(), true,article);
		return new ResponseEntity(newInvoiceItem, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/invoiceItems/{id}")
	public ResponseEntity<Void> deleteInvoiceItem(@PathVariable("id") Long id) {
		InvoiceItem invoiceItem = invoiceItemService.getInoviceItem(id);
		if(invoiceItem == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		invoiceItemService.removeInvoiceItem(invoiceItem);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
