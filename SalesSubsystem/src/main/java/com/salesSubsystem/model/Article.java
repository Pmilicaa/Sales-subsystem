package com.salesSubsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="article")
public class Article {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "unit_of_measure_article", referencedColumnName = "id", nullable = false)
	private UnitOfMeasure unitOfMeasure;

	@OneToMany(
			mappedBy = "id",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
	)
	private List<PriceList> priceLists;

	@ManyToOne
	@JoinColumn(name = "article_group_article", referencedColumnName = "id", nullable = false)
	private ArticleGroup articleGroup;

	@OneToMany(
			mappedBy = "id",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
	)
	private List<InvoiceItem> invoiceItems;

	@ManyToOne
	@JoinColumn(name = "company_article", referencedColumnName = "id", nullable = false)
	private Company company;

	@Column(name="active")
	private boolean active;

	public Article(long id, String name, String description, UnitOfMeasure unitOfMeasure, List<PriceList> priceLists, ArticleGroup articleGroup, List<InvoiceItem> invoiceItems, Company company, boolean active) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitOfMeasure = unitOfMeasure;
		this.priceLists = priceLists;
		this.articleGroup = articleGroup;
		this.invoiceItems = invoiceItems;
		this.company = company;
		this.active = active;
	}

	public Article() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArticleGroup getArticleGroup() {
		return articleGroup;
	}
	public void setArticleGroup(ArticleGroup articleGroup) {
		this.articleGroup = articleGroup;
	}
	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public List<PriceList> getPriceLists() {
		return priceLists;
	}
	public void setPriceLists(List<PriceList> priceLists) {
		this.priceLists = priceLists;
	}
	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}
	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}
	public Company getCompany() {return company;}
	public void setCompany(Company company) {this.company = company;}
	public boolean isActive() {return active;}
	public void setActive(boolean active) {this.active = active;}
}
