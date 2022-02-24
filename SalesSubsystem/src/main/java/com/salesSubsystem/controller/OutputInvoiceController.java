package com.salesSubsystem.controller;

import com.salesSubsystem.dto.OutputInvoiceDto;
import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.InvoiceItem;
import com.salesSubsystem.model.PDV;
import com.salesSubsystem.service.ArticleService;
import com.salesSubsystem.service.InvoiceItemService;
import com.salesSubsystem.service.PDVService;
import org.apache.tomcat.jni.OS;
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

import com.salesSubsystem.model.BusinessYear;
import com.salesSubsystem.model.OutputInvoice;
import com.salesSubsystem.service.OutputInvoiceService;

import java.util.Date;
import java.util.List;
import java.util.Random;

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

	//	Long id, int numberAccount, Date releaseDate, java.util.Date valueDate, double totalBase,
//	double totalPDV, double totalPayment, boolean active, Status status, Company company,
//	List<InvoiceItem> invoiceItems, BusinessYear businessYear, BusinessPartner businessPartner
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@PostMapping(path = "/outputInvoices")
	public @ResponseBody ResponseEntity<?> saveOutputInvoice(@RequestBody List<OutputInvoiceDto> outputInvoiceDtos) {
		InvoiceItem invoiceItem= null;

		for(OutputInvoiceDto outputInvoiceDto : outputInvoiceDtos){
			Article article = articleService.getArticle(outputInvoiceDto.getArticleId());
			Random random = new Random();
			int randomWithNextInt = random.nextInt();
		//	PDV pdv = pdvService.getPDVByArticleGroup(article.getArticleGroup());
			PDV nullPdv = new PDV(new Date(), 0, article.getArticleGroup());

			//int serialNumbAccItem, int amount, double discount, double unitPrice, double base,
			//					   double percentagePDV, double total, boolean active, Article article, OutputInvoice outputInvoice
			//if(pdv == null){
//				invoiceItem = new InvoiceItem(randomWithNextInt,outputInvoiceDto.getAmount(), outputInvoiceDto.getDiscount(), outputInvoiceDto.getPrice(),
//						outputInvoiceDto.getPrice(), outputInvoiceService.getTotal(outputInvoiceDto.getPrice(),outputInvoiceDto.getAmount(), outputInvoiceDto.getDiscount(), nullPdv.getPdvAssessment()), 100, true,article,null);

		//	}else{
				invoiceItem = new InvoiceItem(randomWithNextInt,outputInvoiceDto.getAmount(), outputInvoiceDto.getDiscount(), outputInvoiceDto.getPrice(),
						outputInvoiceDto.getPrice(),nullPdv.getPdvAssessment(), outputInvoiceService.getTotal(outputInvoiceDto.getPrice(),outputInvoiceDto.getAmount(), outputInvoiceDto.getDiscount(), nullPdv.getPdvAssessment()), true,article,null);
		//	}
		}

		InvoiceItem newInvoice = invoiceItemService.saveInoviceItem(invoiceItem);

//       OutputInvoice outputInvoice = new OutputInvoice(numberAccount, new Date(), new Date(), )
//		OutputInvoice newOutputInvoice = outputInvoiceService.saveOutputInvoice(outputInvoice);
		return new ResponseEntity(invoiceItem, HttpStatus.OK);
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
