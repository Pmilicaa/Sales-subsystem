package com.salesSubsystem.dto;

public class BusinessPartnerDto {
    private String namePartner;
    private String address;
    private String contact;
    private String eMail;
    private long pib;
    private long mib;

    public BusinessPartnerDto() {
    }

    public BusinessPartnerDto(String namePartner, String address, String contact, String eMail, long pib, long mib) {
        this.namePartner = namePartner;
        this.address = address;
        this.contact = contact;
        this.eMail = eMail;
        this.pib = pib;
        this.mib = mib;
    }

    public String getNamePartner() {
        return namePartner;
    }

    public void setNamePartner(String namePartner) {
        this.namePartner = namePartner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public long getPib() {
        return pib;
    }

    public void setPib(long pib) {
        this.pib = pib;
    }

    public long getMib() {
        return mib;
    }

    public void setMib(long mib) {
        this.mib = mib;
    }
}
