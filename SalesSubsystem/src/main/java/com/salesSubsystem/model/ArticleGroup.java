package com.salesSubsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="articleGroup")
public class ArticleGroup {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(name="name")
	private String name;

	@OneToMany(
			mappedBy = "id",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
	)
	@JsonBackReference (value="articleGroup_article")
	private List<Article> articles;


	@OneToMany(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
	)
	@JsonBackReference(value="articleGroup_pdv")
	private List<PDV> pdvs;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "company_article_group", referencedColumnName = "id")
	@JsonManagedReference(value="company_article_group")
	private Company company;

	public ArticleGroup(String name, List<Article> articles, List<PDV> pdvs, Company company) {
		this.name = name;
		this.articles = articles;
		this.pdvs = pdvs;
		this.company = company;
	}

	public ArticleGroup(long id, String name, List<Article> articles, List<PDV> pdvs, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.articles = articles;
		this.pdvs = pdvs;
		this.company = company;
	}

	public ArticleGroup() {
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
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public List<PDV> getPdvs() {
		return pdvs;
	}
	public void setPdvs(List<PDV> pdvs) {
		this.pdvs = pdvs;
	}
	public Company getCompany() {return company;}
	public void setCompany(Company company) {this.company = company;}
}
