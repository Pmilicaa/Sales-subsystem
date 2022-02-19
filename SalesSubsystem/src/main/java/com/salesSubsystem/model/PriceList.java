 package com.salesSubsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

 @Entity
@Table(name="priceList")
public class PriceList {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(name="valid_from")
	private Date validFrom;

	 @OneToMany(
			 mappedBy = "id",
			 fetch = FetchType.LAZY,
			 cascade = CascadeType.ALL
	 )
	 private List<PriceListItem> items;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "company_price", referencedColumnName = "id", nullable = true)
	@JsonBackReference(value="price_company")
	private Company company;

	public PriceList(long id, Date validFrom, List<PriceListItem> items, Company company) {
		super();
		this.id = id;
		this.validFrom = validFrom;
		this.items = items;
		this.company = company;
	}
	public PriceList(Date validFrom, List<PriceListItem> items, Company company) {
		this.validFrom = validFrom;
		this.items = items;
		this.company = company;
	}

	public PriceList() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public List<PriceListItem> getItems() {
		return items;
	}
	public void setItems(List<PriceListItem> items) {
		this.items = items;
	}
	public Company getCompany() {return company;}
	public void setCompany(Company company) {this.company = company;}
}
