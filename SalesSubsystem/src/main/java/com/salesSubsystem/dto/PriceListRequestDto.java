package com.salesSubsystem.dto;

import java.util.List;

public class PriceListRequestDto {

    private List<ArticlePriceDto> articlePriceList;

    @Override
    public String toString() {
        String newDto = null;
        for(ArticlePriceDto dto : articlePriceList){
            newDto +=dto.getPrice() +' ' + dto.getArticleId() + '\n' ;
        }return newDto;
    }

    public PriceListRequestDto() {
    }

    public PriceListRequestDto(List<ArticlePriceDto> articlePriceList) {
        this.articlePriceList = articlePriceList;
    }

    public List<ArticlePriceDto> getArticlePriceList() {
        return articlePriceList;
    }

    public void setArticlePriceList(List<ArticlePriceDto> articlePriceList) {
        this.articlePriceList = articlePriceList;
    }
}
