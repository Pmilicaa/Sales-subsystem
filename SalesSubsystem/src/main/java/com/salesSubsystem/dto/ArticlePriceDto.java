package com.salesSubsystem.dto;

public class ArticlePriceDto {
    private double price;
    private long articleId;


    public ArticlePriceDto() {
    }

    public ArticlePriceDto(double price, long articleId) {
        this.price = price;
        this.articleId = articleId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }
}
