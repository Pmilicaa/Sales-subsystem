package com.salesSubsystem.dto;

public class ArticleDto {
    private String name;
    private String description;
    private long price;
    private long pib;
    private long uom;
    private long group;

    public ArticleDto() {
    }

    public ArticleDto(String name, String description, long price, long pib, long uom, long articleGroup) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pib = pib;
        this.uom = uom;
        this.group = articleGroup;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setPib(long pib) {
        this.pib = pib;
    }

    public void setUom(long uom) {
        this.uom = uom;
    }

    public void setGroup(long articleGroup) {
        this.group = articleGroup;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getPrice() {
        return price;
    }

    public long getPib() {
        return pib;
    }

    public long getUom() {
        return uom;
    }

    public long getGroup() {
        return group;
    }
}
