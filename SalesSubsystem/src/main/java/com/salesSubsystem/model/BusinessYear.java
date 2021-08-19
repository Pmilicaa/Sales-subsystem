package com.salesSubsystem.model;

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
@Table(name = "BusinessYear")
public class BusinessYear {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "locked")
	private boolean locked;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId", referencedColumnName = "id")
	private Company company;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "businessYear")
	private List<OutputInvoice> outputInvoices;
	
	public BusinessYear(Long id, int year, boolean locked, Company company, List<OutputInvoice> outputInvoices) {
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

	public void setId(Long id) {
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

