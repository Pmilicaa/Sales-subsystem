 package com.salesSubsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="priceList")
public class PriceList {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(name="valid_from")
	private Date validFrom;

	@Column(name="price_per_unit")
	private double pricePerUnit;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "article_price", referencedColumnName = "id", nullable = true)
	@JsonBackReference(value="price_article")
	private Article article;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "company_price", referencedColumnName = "id", nullable = true)
	@JsonBackReference(value="price_company")
	private Company company;

	public PriceList(long id, Date validFrom, double pricePerUnit, Article article, Company company) {
		super();
		this.id = id;
		this.validFrom = validFrom;
		this.pricePerUnit = pricePerUnit;
		this.article = article;
		this.company = company;
	}
	public PriceList(Date validFrom, double pricePerUnit, Article article, Company company) {
		this.validFrom = validFrom;
		this.pricePerUnit = pricePerUnit;
		this.article = article;
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
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Company getCompany() {return company;}
	public void setCompany(Company company) {this.company = company;}
}
