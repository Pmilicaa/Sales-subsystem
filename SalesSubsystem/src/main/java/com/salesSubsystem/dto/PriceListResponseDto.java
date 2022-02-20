package com.salesSubsystem.dto;

import java.util.Date;

public class PriceListResponseDto {
    private long validDate;
    private double price;
    private String articleName;
    private String articleGroupName;
    private long pib;

    public PriceListResponseDto() {
    }

    public PriceListResponseDto(long validDate, double price, String articleName, String articleGroupName, long pib) {
        this.validDate = validDate;
        this.price = price;
        this.articleName = articleName;
        this.articleGroupName = articleGroupName;
        this.pib = pib;
    }

    public long getValidDate() {
        return validDate;
    }

    public void setValidDate(long validDate) {
        this.validDate = validDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleGroupName() {
        return articleGroupName;
    }

    public void setArticleGroupName(String articleGroupName) {
        this.articleGroupName = articleGroupName;
    }

    public long getPib() {
        return pib;
    }

    public void setPib(long pib) {
        this.pib = pib;
    }
}
