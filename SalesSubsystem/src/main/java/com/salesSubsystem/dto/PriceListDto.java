package com.salesSubsystem.dto;

public class PriceListDto {
    private long id;
    private long validDate;
    private long pib;

    public PriceListDto() {
    }

    public PriceListDto(long id,long validDate, long pib) {
        this.id= id;
        this.validDate = validDate;
        this.pib = pib;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getValidDate() {
        return validDate;
    }

    public void setValidDate(long validDate) {
        this.validDate = validDate;
    }

    public long getPib() {
        return pib;
    }

    public void setPib(long pib) {
        this.pib = pib;
    }
}
