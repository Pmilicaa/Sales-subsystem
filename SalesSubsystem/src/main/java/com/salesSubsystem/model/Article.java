package com.salesSubsystem.model;

import java.util.List;

public class Article {
	
	private long id;
	private String name;
	private String description;
	private UnitOfMeasure unitOfMeasure;
	private List<PriceList> priceLists;
	private ArticleGroup articleGroup;

	public Article(long id, String name, String description, UnitOfMeasure unitOfMeasure, List<PriceList> priceLists,
			ArticleGroup articleGroup) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitOfMeasure = unitOfMeasure;
		this.priceLists = priceLists;
		this.articleGroup = articleGroup;
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

}
