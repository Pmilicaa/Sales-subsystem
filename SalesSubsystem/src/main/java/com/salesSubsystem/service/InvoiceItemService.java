package com.salesSubsystem.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.salesSubsystem.dto.AddInvoiceItemDto;
import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.OutputInvoice;
import com.salesSubsystem.model.PDV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesSubsystem.model.InvoiceItem;
import com.salesSubsystem.repository.InvoiceItemRepository;


@Service
public class InvoiceItemService {

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Autowired
	private ArticleService articleService;

	public List<InvoiceItem> getAllInvoiceItems() {
		return invoiceItemRepository.findAll();
	}
	
	public InvoiceItem getInoviceItem(Long id) {
		return invoiceItemRepository.findById(id).get();
	}
	
	public InvoiceItem saveInoviceItem(InvoiceItem invoiceItem) {
		return invoiceItemRepository.save(invoiceItem);
	}

	public InvoiceItem createInvoiceItem(AddInvoiceItemDto addInvoiceItemDto){
		Article article = articleService.getArticle(addInvoiceItemDto.getArticleId());
		PDV nullPdv = new PDV(new Date(), 0, article.getArticleGroup());

		InvoiceItem invoiceItem = new InvoiceItem(UUID.randomUUID().toString(), addInvoiceItemDto.getAmount(),
				addInvoiceItemDto.getDiscount(), addInvoiceItemDto.getPrice(), addInvoiceItemDto.getPrice(), 10,
				calculateTotal(addInvoiceItemDto.getPrice(), addInvoiceItemDto.getAmount(), addInvoiceItemDto.getDiscount(), nullPdv.getPdvAssessment()),
				true,article);
		return invoiceItem;
	}

	private double calculateTotal(double price, int amount, double discount, double pdv){
		double discountValue = price * discount/100;
		double priceWithPDV=price * pdv/100;
		if(discount == 0){
			discountValue = 0;
		}
		if(pdv == 0){
			priceWithPDV = 0;
		}
		return (price - discountValue + priceWithPDV ) * amount;
	}

	public void removeInvoiceItem(InvoiceItem invoiceItem) {
		//invoiceItem.setActive(false);
		//invoiceItemRepository.save(invoiceItem);
	}
	
}
