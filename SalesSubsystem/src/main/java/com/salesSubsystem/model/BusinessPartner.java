package com.salesSubsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "BusinessPartner")
public class BusinessPartner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "namePartner")
	private String namePartner;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "eMail")
	private String eMail;
	
	@Column(name = "PIB")
	private long PIB;
	
	@Column(name = "MIB")
	private long MIB;
	
	@Column(name = "active")
	private boolean active = true;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId", referencedColumnName = "id")
	@JsonBackReference(value="company_businessPartners")
	private Company company;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "businessPartner")
	@JsonManagedReference(value="outputInvoices_businessPartner")
	private List<OutputInvoice> outputInvoices;
	
	
	public BusinessPartner(long id, String namePartner, String address, String contact, String eMail,
							long pIB, long mIB, boolean active, Company company, List<OutputInvoice> outputInvoices) {
		this.id = id;
		this.namePartner = namePartner;
		this.address = address;
		this.contact = contact;
		this.eMail = eMail;
		this.PIB = pIB;
		this.MIB = mIB;
		this.active = active;
		this.company = company;
		this.outputInvoices = outputInvoices;
	}

	public BusinessPartner(String namePartner, String address, String contact, String eMail, long PIB, long MIB, boolean active, Company company, List<OutputInvoice> outputInvoices) {
		this.namePartner = namePartner;
		this.address = address;
		this.contact = contact;
		this.eMail = eMail;
		this.PIB = PIB;
		this.MIB = MIB;
		this.active = active;
		this.company = company;
		this.outputInvoices = outputInvoices;
	}

	public BusinessPartner() {
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNamePartner() {
		return namePartner;
	}
	public void setNamePartner(String namePartner) {
		this.namePartner = namePartner;
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
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<OutputInvoice> getOutputInvoices() {
		return outputInvoices;
	}
	public void setOutputInvoices(List<OutputInvoice> outputInvoices) {
		this.outputInvoices = outputInvoices;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}

