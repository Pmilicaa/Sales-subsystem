package com.salesSubsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.salesSubsystem.dto.AddInvoiceDto;
import com.salesSubsystem.dto.AddInvoiceItemDto;
import com.salesSubsystem.dto.ArticleInvoiceItemDto;
import com.salesSubsystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salesSubsystem.repository.OutputInvoiceRepository;


@Service
public class OutputInvoiceService {

    @Autowired
    private OutputInvoiceRepository outputInvoiceRepository;

    private final InvoiceItemService invoiceItemService;
    private final CompanyService companyService;
    private final BusinessYearService businessYearService;
    private final BusinessPartnerService businessPartnerService;
    private final ArticleService articleService;

    public OutputInvoiceService(InvoiceItemService invoiceItemService, CompanyService companyService, BusinessYearService businessYearService,
                                BusinessPartnerService businessPartnerService, ArticleService articleService) {
        this.invoiceItemService = invoiceItemService;
        this.companyService = companyService;
        this.businessYearService = businessYearService;
        this.businessPartnerService = businessPartnerService;
        this.articleService = articleService;
    }

    public List<OutputInvoice> getAllOutputInvoices() {
        return outputInvoiceRepository.findAll();
    }

    public OutputInvoice getOutputInvoice(Long id) {
        return outputInvoiceRepository.findById(id).get();
    }

    public OutputInvoice saveOutputInvoice(OutputInvoice outputInvoice) {
        return outputInvoiceRepository.saveAndFlush(outputInvoice);
    }

    public OutputInvoice createInvoice(AddInvoiceDto addInvoiceDto) {
        Company company = companyService.findByPriceListsId(addInvoiceDto.getPriceListId());
        BusinessYear currentBusinessYear = businessYearService.findCurrentYearByCompany(company);
        BusinessPartner businessPartner = businessPartnerService.getBusinessPartner(addInvoiceDto.getBusinessPartnerId());

        List<InvoiceItem> invoiceItems = new ArrayList<>();
        for (AddInvoiceItemDto addInvoiceItemDto : addInvoiceDto.getAddInvoiceItemDtoList()) {
            InvoiceItem invoiceItem = invoiceItemService.createInvoiceItem(addInvoiceItemDto);
            invoiceItems.add(invoiceItem);
            Article article = invoiceItem.getArticle();
            article.getInvoiceItems().add(invoiceItem);
        }

        OutputInvoice outputInvoice = new OutputInvoice(UUID.randomUUID().toString(), System.currentTimeMillis(),
                System.currentTimeMillis(), calculateTotalBase(invoiceItems), calculateTotalPdv(invoiceItems),
                calculateTotalPayment(invoiceItems), true, Status.F, company, invoiceItems, currentBusinessYear, businessPartner);
        return outputInvoice;
    }

    private double calculateTotalPayment(List<InvoiceItem> invoiceItems) {
        double totalPayment = 0;
        for (InvoiceItem invoiceItem : invoiceItems) {
            totalPayment += invoiceItem.getTotal();
        }
        return totalPayment;
    }

    private double calculateTotalPdv(List<InvoiceItem> invoiceItems) {
        double totalPdv = 0;
        for (InvoiceItem invoiceItem : invoiceItems) {
            totalPdv += invoiceItem.getPercentagePDV();
        }
        return totalPdv;
    }

    private double calculateTotalBase(List<InvoiceItem> invoiceItems) {
        double totalBase = 0;
        for (InvoiceItem invoiceItem : invoiceItems) {
            totalBase += invoiceItem.getBase();
        }
        return totalBase;
    }

    public void removeOutputInvoice(OutputInvoice outputInvoice) {
        outputInvoice.setActive(false);
        outputInvoiceRepository.save(outputInvoice);
    }

}
