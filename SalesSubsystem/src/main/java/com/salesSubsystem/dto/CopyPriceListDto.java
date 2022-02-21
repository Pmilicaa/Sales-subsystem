package com.salesSubsystem.dto;

import java.util.List;

public class CopyPriceListDto {
    private long pdv;
    private long priceListId;
    private String pdv_type;
    private List<ArticlePriceDto> articlePriceList;

    public CopyPriceListDto() {
    }

    public CopyPriceListDto(long pdv, long priceListId, String pdv_type, List<ArticlePriceDto> articlePriceList) {
        this.pdv = pdv;
        this.priceListId = priceListId;
        this.pdv_type = pdv_type;
        this.articlePriceList = articlePriceList;
    }

    public long getPdv() {
        return pdv;
    }

    public void setPdv(long pdv) {
        this.pdv = pdv;
    }

    public long getPriceListId() {
        return priceListId;
    }

    public List<ArticlePriceDto> getArticlePriceList() {
        return articlePriceList;
    }

    public void setArticlePriceList(List<ArticlePriceDto> articlePriceList) {
        this.articlePriceList = articlePriceList;
    }

    public void setPriceListId(long priceListId) {
        this.priceListId = priceListId;
    }

    public String getPdv_type() {
        return pdv_type;
    }

    public void setPdv_type(String pdv_type) {
        this.pdv_type = pdv_type;
    }
}
