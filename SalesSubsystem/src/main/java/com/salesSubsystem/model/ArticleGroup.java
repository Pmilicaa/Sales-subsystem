package com.salesSubsystem.model;

import java.util.List;

public class ArticleGroup {
	
	private long id;
	private String name;
	private List<Article> articles;
	private List<PDV> pdvs;

	public ArticleGroup(long id, String name, List<Article> articles, List<PDV> pdvs) {
		super();
		this.id = id;
		this.name = name;
		this.articles = articles;
		this.pdvs = pdvs;
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
}
