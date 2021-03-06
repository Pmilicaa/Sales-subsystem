package com.salesSubsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"company"})
@Entity
@Table(name="article")
public class Article {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "unit_of_measure_article", referencedColumnName = "id")
	@JsonManagedReference (value="unitOfMeasure_article")
	private UnitOfMeasure unitOfMeasure;


	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "price_list_item")
	@JsonManagedReference (value="article_price")
	private PriceListItem priceListItem;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "article_group_article", referencedColumnName = "id")
	@JsonManagedReference (value="articleGroup_article")
	private ArticleGroup articleGroup;

	@OneToMany(
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
	)
	@JsonManagedReference(value="invoiceItems_article")
	private List<InvoiceItem> invoiceItems;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "company_article", referencedColumnName = "id")
	@JsonManagedReference(value="company_article")
	private Company company;

	@Column(name="active")
	private boolean active;

	public Article(Long id, String name, String description, UnitOfMeasure unitOfMeasure, PriceListItem priceListItem, ArticleGroup articleGroup, List<InvoiceItem> invoiceItems, Company company, boolean active) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitOfMeasure = unitOfMeasure;
		this.priceListItem = priceListItem;
		this.articleGroup = articleGroup;
		this.invoiceItems = invoiceItems;
		this.company = company;
		this.active = active;
	}

	public Article(String name, String description, UnitOfMeasure unitOfMeasure, PriceListItem priceListItem, ArticleGroup articleGroup, List<InvoiceItem> invoiceItems, Company company) {
		this.name = name;
		this.description = description;
		this.unitOfMeasure = unitOfMeasure;
		this.priceListItem = priceListItem;
		this.articleGroup = articleGroup;
		this.invoiceItems = invoiceItems;
		this.company = company;
		this.active = true;
	}

	public Article() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public PriceListItem getPriceListItem() {
		return priceListItem;
	}
	public void setPriceListItem(PriceListItem priceListItem) {
		this.priceListItem = priceListItem;
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
