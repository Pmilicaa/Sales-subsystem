package com.salesSubsystem.dto;

public class ArticleGroupDto {
    private String name;
    private long pib;

    public ArticleGroupDto() {
    }

    public ArticleGroupDto(String name, long pib) {
        this.name = name;
        this.pib = pib;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPib() {
        return pib;
    }

    public void setPib(long pib) {
        this.pib = pib;
    }
}
