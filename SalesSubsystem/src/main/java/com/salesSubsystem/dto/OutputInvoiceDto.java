package com.salesSubsystem.dto;

public class OutputInvoiceDto {
    private long articleId;
    private int amount;
    private double discount;
    private double price;

    public OutputInvoiceDto() {
    }

    public OutputInvoiceDto(long articleId, int amount, double discount,  double price) {
        this.articleId = articleId;
        this.amount = amount;
        this.discount = discount;
        this.price =price;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
}
