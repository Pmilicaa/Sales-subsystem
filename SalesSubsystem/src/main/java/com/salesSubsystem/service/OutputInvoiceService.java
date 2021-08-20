package com.salesSubsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesSubsystem.model.BusinessPartner;
import com.salesSubsystem.model.OutputInvoice;
import com.salesSubsystem.repository.BusinessPartnerRepository;
import com.salesSubsystem.repository.OutputInvoiceRepository;


@Service
public class OutputInvoiceService {

	@Autowired
	private OutputInvoiceRepository outputInvoiceRepository;
	
	public List<OutputInvoice> getAllOutputInvoices() {
		return outputInvoiceRepository.findAll();
	}
	
	public OutputInvoice getOutputInvoice(Long id) {
		return outputInvoiceRepository.findById(id).get();
	}
	
	public OutputInvoice saveOutputInvoice(OutputInvoice outputInvoice) {
		return outputInvoiceRepository.save(outputInvoice);
	}
	
	public void removeOutputInvoice(OutputInvoice outputInvoice) {
		//outputInvoice.setActive(false);
		//outputInvoiceRepository.save(outputInvoice);
	}
	
}
