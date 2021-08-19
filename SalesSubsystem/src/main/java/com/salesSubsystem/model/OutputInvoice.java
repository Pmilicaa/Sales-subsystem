package com.salesSubsystem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OutputInvoice")
public class OutputInvoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "numberAccount")
	private int numberAccount;
	
	@Column(name = "releaseDate")
	private Date releaseDate;
	
	@Column(name = "valueDate")
	private Date valueDate;
	
	@Column(name = "totalBase")
	private double totalBase;
	
	@Column(name = "totalPDV")
	private double totalPDV;
	
	@Column(name = "totalPayment")
	private double totalPayment;
	
	@Column(name = "status")
	private Status status;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId", referencedColumnName = "id")
	private Company company;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "outputInvoice")
	private List<InvoiceItem> invoiceItems;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "businessYearId", referencedColumnName = "id")
	private BusinessYear businessYear;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "businessPartnerId", referencedColumnName = "id")
	private BusinessPartner businessPartner;
	
	
	public OutputInvoice(Long id, int numberAccount, Date releaseDate, Date valueDate, double totalBase,
			double totalPDV, double totalPayment, Status status, Company company, 
			List<InvoiceItem> invoiceItems, BusinessYear businessYear, BusinessPartner businessPartner) {
		this.id = id;
		this.numberAccount = numberAccount;
		this.releaseDate = releaseDate;
		this.valueDate = valueDate;
		this.totalBase = totalBase;
		this.totalPDV = totalPDV;
		this.totalPayment = totalPayment;
		this.status = status;
		this.company = company;
		this.invoiceItems = invoiceItems;
		this.businessYear = businessYear;
		this.businessPartner = businessPartner;
	}


	public OutputInvoice() {

	}


	public long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNumberAccount() {
		return numberAccount;
	}


	public void setNumberAccount(int numberAccount) {
		this.numberAccount = numberAccount;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public Date getValueDate() {
		return valueDate;
	}


	public void setValueDate(Date valueDate) {
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


	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}


	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
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

