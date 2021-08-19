package com.salesSubsystem.model;

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
	private List<Article> articles;

	@OneToMany(
			mappedBy = "id",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
	)
	private List<PDV> pdvs;

	@Transient
	private Company company;

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