package com.salesSubsystem.dto;
public class InvoiceItemDto {


    private int amount;

    private double discount;

     private double unitPrice;

    private double base;

    private double percentagePDV;

    private double total;

    private long articleId;

    public InvoiceItemDto(int amount, double discount, double unitPrice, double base,
                       double percentagePDV, double total, long articleId) {

        this.amount = amount;
        this.discount = discount;
        this.unitPrice = unitPrice;
        this.base = base;
        this.percentagePDV = percentagePDV;
        this.total = total;
        this.articleId = articleId;
    }


    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public InvoiceItemDto() {

    }


    public int getAmount() {
        return amount;
    }


    public void setAmount(int amount) {
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


    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }

}

