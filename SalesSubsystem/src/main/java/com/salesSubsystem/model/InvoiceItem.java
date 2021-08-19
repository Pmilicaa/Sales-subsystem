package com.salesSubsystem.model;

public class InvoiceItem {

	private long id;
	private int serialNumbAccItem;
	private double amount;
	private double discount;
	private double unitPrice;
	private double base;
	private double percentagePDV;
	private double amountPDV;
	private double total;
	private Article article;
	private OutputInvoice outputInvoice;
	
	
	public InvoiceItem(long id, int serialNumbAccItem, double amount, double discount, double unitPrice, double base,
			double percentagePDV, double amountPDV, double total, Article article, OutputInvoice outputInvoice) {
		this.id = id;
		this.serialNumbAccItem = serialNumbAccItem;
		this.amount = amount;
		this.discount = discount;
		this.unitPrice = unitPrice;
		this.base = base;
		this.percentagePDV = percentagePDV;
		this.amountPDV = amountPDV;
		this.total = total;
		this.article = article;
		this.outputInvoice = outputInvoice;
	}


	public InvoiceItem() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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

}

