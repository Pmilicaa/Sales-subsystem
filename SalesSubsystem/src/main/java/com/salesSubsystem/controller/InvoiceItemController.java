package com.salesSubsystem.controller;

import com.salesSubsystem.dto.InvoiceItemDto;
import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.BusinessPartner;
import com.salesSubsystem.model.Company;
import com.salesSubsystem.service.ArticleService;
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

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class InvoiceItemController {

	@Autowired
	private InvoiceItemService invoiceItemService;

	@Autowired
	private ArticleService articleService;

	@GetMapping(path = "/invoiceItems")
	public @ResponseBody ResponseEntity<?> getAllInoviceItems() {
		return new ResponseEntity(invoiceItemService.getAllInvoiceItems(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/invoiceItems/{id}")
	public ResponseEntity<?> getInvoiceItem(@PathVariable("id") Long id) {
		InvoiceItem invoiceItem = invoiceItemService.getInoviceItem(id);
		if(invoiceItem == null) {
			return new ResponseEntity<InvoiceItem>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(invoiceItem, HttpStatus.OK);
	}
	//public InvoiceItem(int serialNumbAccItem, double amount, double discount, double unitPrice, double base,
	//					   double percentagePDV, double amountPDV, double total, boolean active,
	//					   Article article, OutputInvoice outputInvoice) {
	//
//	Long id, int numberAccount, Date releaseDate, java.util.Date valueDate, double totalBase,
//	double totalPDV, double totalPayment, boolean active, Status status, Company company,
//	List<InvoiceItem> invoiceItems, BusinessYear businessYear, BusinessPartner businessPartner
	@PostMapping(path = "/invoiceItems")
	public @ResponseBody ResponseEntity<?> saveInvoiceItem(@RequestBody InvoiceItemDto invoiceItem) {
		Article article = articleService.getArticle(invoiceItem.getArticleId());
		Random random = new Random();
		int randomWithNextInt = random.nextInt();
		InvoiceItem newInvoiceItem = new InvoiceItem(randomWithNextInt, invoiceItem.getAmount(),
				invoiceItem.getDiscount(), invoiceItem.getUnitPrice(),
				invoiceItem.getBase(), invoiceItem.getPercentagePDV(),
				 invoiceItem.getTotal(),
				true,article, null);
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
