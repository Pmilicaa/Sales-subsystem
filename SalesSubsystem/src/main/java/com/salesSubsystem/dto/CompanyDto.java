package com.salesSubsystem.dto;

public class CompanyDto {
    private String address;
    private String contact;
    private long pib;
    private long mib;

    public CompanyDto(String address, String contact, long pib, long mib) {
        this.address = address;
        this.contact = contact;
        this.pib = pib;
        this.mib = mib;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
