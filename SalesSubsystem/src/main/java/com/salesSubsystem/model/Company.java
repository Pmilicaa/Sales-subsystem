package com.salesSubsystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "PIB")
	private long PIB;
	
	@Column(name = "MIB")
	private long MIB;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	private List<BusinessYear> businessYears;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	private List<BusinessPartner> businessPartners;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	private List<PriceList> priceLists;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	private List<Article> articles;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	private List<ArticleGroup> articleGroups;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	private List<OutputInvoice> outputInvoices;
	
	public Company(Long id, String address, String contact, long pIB, long mIB, 
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

	public void setId(Long id) {
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

