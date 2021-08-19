package com.salesSubsystem.model;

import java.util.List;

public class Company {

	private long id;
	private String address;
	private String contact;
	private long PIB;
	private long MIB;
	private List<BusinessYear> businessYears;
	private List<BusinessPartner> businessPartners;
	private List<PriceList> priceLists;
	private List<Article> articles;
	private List<ArticleGroup> articleGroups;
	private List<OutputInvoice> outputInvoices;
	
	public Company(long id, String address, String contact, long pIB, long mIB, 
					List<BusinessYear> businessYears, List<BusinessPartner> businessPartners, 
					List<PriceList> priceLists, List<Article> articles, List<ArticleGroup> articleGroups, List<OutputInvoice> outputInvoices) {
		this.id = id;
		this.address = address;
		this.contact = contact;
		PIB = pIB;
		MIB = mIB;
		this.businessYears = businessYears;
		this.businessPartners = businessPartners;
		this.priceLists = priceLists;
		this.articles = articles;
		this.articleGroups = articleGroups;
		this.outputInvoices = outputInvoices;
	}

	public Company() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public long getPIB() {
		return PIB;
	}

	public void setPIB(long pIB) {
		PIB = pIB;
	}

	public long getMIB() {
		return MIB;
	}

	public void setMIB(long mIB) {
		MIB = mIB;
	}

	public List<BusinessYear> getBusinessYears() {
		return businessYears;
	}

	public void setBusinessYears(List<BusinessYear> businessYears) {
		this.businessYears = businessYears;
	}

	public List<BusinessPartner> getBusinessPartners() {
		return businessPartners;
	}

	public void setBusinessPartners(List<BusinessPartner> businessPartners) {
		this.businessPartners = businessPartners;
	}

	public List<PriceList> getPriceLists() {
		return priceLists;
	}

	public void setPriceLists(List<PriceList> priceLists) {
		this.priceLists = priceLists;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<ArticleGroup> getArticleGroups() {
		return articleGroups;
	}

	public void setArticleGroups(List<ArticleGroup> articleGroups) {
		this.articleGroups = articleGroups;
	}

	public List<OutputInvoice> getOutputInvoices() {
		return outputInvoices;
	}

	public void setOutputInvoices(List<OutputInvoice> outputInvoices) {
		this.outputInvoices = outputInvoices;
	}
	
	
}

