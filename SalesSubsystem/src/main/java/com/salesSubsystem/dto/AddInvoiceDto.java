package com.salesSubsystem.dto;

import java.util.List;

public class AddInvoiceDto {
    private int priceListId;
    private Long businessPartnerId;
    private List<AddInvoiceItemDto> addInvoiceItemDtoList;

    public AddInvoiceDto(int priceListId, Long businessPartnerId, List<AddInvoiceItemDto> addInvoiceItemDtoList) {
        this.priceListId = priceListId;
        this.businessPartnerId = businessPartnerId;
        this.addInvoiceItemDtoList = addInvoiceItemDtoList;
    }

    public int getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(int priceListId) {
        this.priceListId = priceListId;
    }

    public Long getBusinessPartnerId() {
        return businessPartnerId;
    }

    public void setBusinessPartnerId(Long businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
    }

    public List<AddInvoiceItemDto> getAddInvoiceItemDtoList() {
        return addInvoiceItemDtoList;
    }

    public void setAddInvoiceItemDtoList(List<AddInvoiceItemDto> addInvoiceItemDtoList) {
        this.addInvoiceItemDtoList = addInvoiceItemDtoList;
    }
}
