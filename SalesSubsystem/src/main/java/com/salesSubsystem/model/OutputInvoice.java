package com.salesSubsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "OutputInvoice")
public class OutputInvoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "numberAccount")
	private String numberAccount;
	
	@Column(name = "releaseDate")
	private Long releaseDate;
	
	@Column(name = "valueDate")
	private Long valueDate;
	
	@Column(name = "totalBase")
	private double totalBase;
	
	@Column(name = "totalPDV")
	private double totalPDV;
	
	@Column(name = "totalPayment")
	private double totalPayment;
	
	@Column(name = "active")
	private boolean active = true;
	
	@Column(name = "status")
	private Status status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference(value="company_outputInvoice")
	private Company company;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="invoice_item_id")
	private List<InvoiceItem> invoiceItems;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference(value="outputInvoices_businessYears")
	private BusinessYear businessYear;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference(value="outputInvoices_businessPartner")
	private BusinessPartner businessPartner;
	
	public OutputInvoice(Long id, String numberAccount, Long releaseDate, Long valueDate, double totalBase,
			double totalPDV, double totalPayment, boolean active, Status status, Company company, 
			List<InvoiceItem> invoiceItems, BusinessYear businessYear, BusinessPartner businessPartner) {
		this.id = id;
		this.numberAccount = numberAccount;
		this.releaseDate = releaseDate;
		this.valueDate = valueDate;
		this.totalBase = totalBase;
		this.totalPDV = totalPDV;
		this.totalPayment = totalPayment;
		this.active = active;
		this.status = status;
		this.company = company;
		this.invoiceItems = invoiceItems;
		this.businessYear = businessYear;
		this.businessPartner = businessPartner;
	}

	public OutputInvoice(String numberAccount, Long releaseDate, Long valueDate, double totalBase,
						 double totalPDV, double totalPayment, boolean active, Status status, Company company,
						 List<InvoiceItem> invoiceItems, BusinessYear businessYear, BusinessPartner businessPartner) {
		this.numberAccount = numberAccount;
		this.releaseDate = releaseDate;
		this.valueDate = valueDate;
		this.totalBase = totalBase;
		this.totalPDV = totalPDV;
		this.totalPayment = totalPayment;
		this.active = active;
		this.status = status;
		this.company = company;
		this.invoiceItems = invoiceItems;
		this.businessYear = businessYear;
		this.businessPartner = businessPartner;
	}

	public OutputInvoice() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}

