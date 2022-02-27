package com.salesSubsystem.dto;

import com.salesSubsystem.model.*;

import java.util.List;

public class OutputInvoiceDto {
    private String numberAccount;
    private Long releaseDate;
    private Long valueDate;
    private double totalBase;
    private double totalPDV;
    private double totalPayment;
    private boolean active;
    private Status status;
    private Company company;
    private List<ArticleInvoiceItemDto> articleInvoices;
    private BusinessYear businessYear;
    private BusinessPartner businessPartner;

    public OutputInvoiceDto(OutputInvoice outputInvoice, List<ArticleInvoiceItemDto> articleInvoices) {
        this.numberAccount = outputInvoice.getNumberAccount();
        this.releaseDate = outputInvoice.getReleaseDate();
        this.valueDate = outputInvoice.getValueDate();
        this.totalBase = outputInvoice.getTotalBase();
        this.totalPDV = outputInvoice.getTotalPDV();
        this.totalPayment = outputInvoice.getTotalPayment();
        this.active = outputInvoice.isActive();
        this.status = outputInvoice.getStatus();
        this.company = outputInvoice.getCompany();
        this.articleInvoices = articleInvoices;
        this.businessYear = outputInvoice.getBusinessYear();
        this.businessPartner = outputInvoice.getBusinessPartner();
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Long getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Long releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getValueDate() {
        return valueDate;
    }

    public void setValueDate(Long valueDate) {
        this.valueDate = valueDate;
    }

    public double getTotalBase() {
        return totalBase;
    }

    public void setTotalBase(double totalBase) {
        this.totalBase = totalBase;
    }

    public double getTotalPDV() {
        return totalPDV;
    }

    public void setTotalPDV(double totalPDV) {
        this.totalPDV = totalPDV;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<ArticleInvoiceItemDto> getArticleInvoices() {
        return articleInvoices;
    }

    public void setArticleInvoices(List<ArticleInvoiceItemDto> articleInvoices) {
        this.articleInvoices = articleInvoices;
    }

    public BusinessYear getBusinessYear() {
        return businessYear;
    }

    public void setBusinessYear(BusinessYear businessYear) {
        this.businessYear = businessYear;
    }

    public BusinessPartner getBusinessPartner() {
        return businessPartner;
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        this.businessPartner = businessPartner;
    }
}
