package com.salesSubsystem.dto;

public class PriceListItemDto {
    private long id;
    private double price;

    public PriceListItemDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
