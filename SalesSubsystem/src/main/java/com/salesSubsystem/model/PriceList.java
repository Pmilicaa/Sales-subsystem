package com.salesSubsystem.model;

import java.util.Date;

public class PriceList {

	private long id;
	private Date validFrom;
	private double pricePerUnit;
	private Article article;

	public PriceList(long id, Date validFrom, double pricePerUnit, Article article) {
		super();
		this.id = id;
		this.validFrom = validFrom;
		this.pricePerUnit = pricePerUnit;
		this.article = article;
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
}
