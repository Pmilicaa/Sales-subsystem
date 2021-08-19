package com.salesSubsystem.model;

import java.util.List;

public class BusinessPartner {

	private long id;
	private String namePartner;
	private String address;
	private String contact;
	private String eMail;
	private long PIB;
	private long MIB;
	private Company company;
	private List<OutputInvoice> outputInvoices;
	
	
	public BusinessPartner(long id, String namePartner, String address, String contact, String eMail, 
							long pIB, long mIB, Company company, List<OutputInvoice> outputInvoices) {
		this.id = id;
		this.namePartner = namePartner;
		this.address = address;
		this.contact = contact;
		this.eMail = eMail;
		PIB = pIB;
		MIB = mIB;
		this.company = company;
		this.outputInvoices = outputInvoices;
	}


	public BusinessPartner() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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

	
}

