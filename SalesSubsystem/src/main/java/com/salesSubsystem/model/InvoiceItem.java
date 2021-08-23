package com.salesSubsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "InvoiceItem")
public class InvoiceItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "serialNumbAccItem")
	private int serialNumbAccItem;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "discount")
	private double discount;
	
	@Column(name = "unitPrice")
	private double unitPrice;
	
	@Column(name = "base")
	private double base;
	
	@Column(name = "percentagePDV")
	private double percentagePDV;
	
	@Column(name = "amountPDV")
	private double amountPDV;
	
	@Column(name = "total")
	private double total;
	
	@Column(name = "active")
	private boolean active = true;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "articleId", referencedColumnName = "id")
	@JsonBackReference(value="invoiceItems_article")
	private Article article;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "outputInvoiceId", referencedColumnName = "id")
	@JsonBackReference(value="invoiceItems_outputInvoice")
	private OutputInvoice outputInvoice;
	
	
	public InvoiceItem(Long id, int serialNumbAccItem, double amount, double discount, double unitPrice, double base,
			double percentagePDV, double amountPDV, double total, boolean active, Article article, OutputInvoice outputInvoice) {
		this.id = id;
		this.serialNumbAccItem = serialNumbAccItem;
		this.amount = amount;
		this.discount = discount;
		this.unitPrice = unitPrice;
		this.base = base;
		this.percentagePDV = percentagePDV;
		this.amountPDV = amountPDV;
		this.total = total;
		this.active = active;
		this.article = article;
		this.outputInvoice = outputInvoice;
	}


	public InvoiceItem() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getSerialNumbAccItem() {
		return serialNumbAccItem;
	}


	public void setSerialNumbAccItem(int serialNumbAccItem) {
		this.serialNumbAccItem = serialNumbAccItem;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public double getBase() {
		return base;
	}


	public void setBase(double base) {
		this.base = base;
	}


	public double getPercentagePDV() {
		return percentagePDV;
	}


	public void setPercentagePDV(double percentagePDV) {
		this.percentagePDV = percentagePDV;
	}


	public double getAmountPDV() {
		return amountPDV;
	}


	public void setAmountPDV(double amountPDV) {
		this.amountPDV = amountPDV;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	public OutputInvoice getOutputInvoice() {
		return outputInvoice;
	}


	public void setOutputInvoice(OutputInvoice outputInvoice) {
		this.outputInvoice = outputInvoice;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
}

