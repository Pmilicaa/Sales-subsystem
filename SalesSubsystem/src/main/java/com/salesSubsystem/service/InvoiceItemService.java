package com.salesSubsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesSubsystem.model.InvoiceItem;
import com.salesSubsystem.repository.InvoiceItemRepository;

public class InvoiceItemService {

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;
	
	public List<InvoiceItem> getAllInvoiceItems() {
		return invoiceItemRepository.findAll();
	}
	
	public InvoiceItem getInoviceItem(Long id) {
		return invoiceItemRepository.findById(id).get();
	}
	
	public InvoiceItem saveInoviceItem(InvoiceItem invoiceItem) {
		return invoiceItemRepository.save(invoiceItem);
	}
	
	public void removeInvoiceItem(InvoiceItem invoiceItem) {
		//invoiceItem.setActive(false);
		//invoiceItemRepository.save(invoiceItem);
	}
	
}
