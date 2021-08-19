package com.salesSubsystem.model;

import java.util.List;

public class BusinessYear {

	private long id;
	private int year;
	private boolean locked;
	private Company company;
	private List<OutputInvoice> outputInvoices;
	
	public BusinessYear(long id, int year, boolean locked, Company company, List<OutputInvoice> outputInvoices) {
		this.id = id;
		this.year = year;
		this.locked = locked;
		this.company = company;
		this.outputInvoices = outputInvoices;
	}

	public BusinessYear() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
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

