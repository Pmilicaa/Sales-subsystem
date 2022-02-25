package com.salesSubsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "InvoiceItem")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serialNumbAccItem")
    private String serialNumbAccItem;

    @Column(name = "amount")
    private int amount;

    @Column(name = "discount")
    private double discount;

    @Column(name = "unitPrice")
    private double unitPrice;

    @Column(name = "base")
    private double base;

    @Column(name = "percentagePDV")
    private double percentagePDV;

    @Column(name = "total")
    private double total;

    @Column(name = "active")
    private boolean active = true;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "invoiceItems_article")
    private Article article;

    public InvoiceItem(Long id, String serialNumbAccItem, int amount, double discount, double unitPrice, double base,
                       double percentagePDV, double total, boolean active, Article article) {
        this.id = id;
        this.serialNumbAccItem = serialNumbAccItem;
        this.amount = amount;
        this.discount = discount;
        this.unitPrice = unitPrice;
        this.base = base;
        this.percentagePDV = percentagePDV;
        this.total = total;
        this.active = active;
        this.article = article;
    }

    public InvoiceItem(String serialNumbAccItem, int amount, double discount, double unitPrice, double base,
                       double percentagePDV, double total, boolean active, Article article) {
        this.serialNumbAccItem = serialNumbAccItem;
        this.amount = amount;
        this.discount = discount;
        this.unitPrice = unitPrice;
        this.base = base;
        this.percentagePDV = percentagePDV;
        this.total = total;
        this.active = active;
        this.article = article;
    }

    public InvoiceItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSerialNumbAccItem() {
        return serialNumbAccItem;
    }


    public void setSerialNumbAccItem(String serialNumbAccItem) {
        this.serialNumbAccItem = serialNumbAccItem;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }


    public double getDiscount() {
        return discount;
    }


    public void setDiscount(double discount) {
        this.discount = discount;
    }


    public double getUnitPrice() {
        return unitPrice;
    }


    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }


    public double getBase() {
        return base;
    }


    public void setBase(double base) {
        this.base = base;
    }


    public double getPercentagePDV() {
        return percentagePDV;
    }


    public void setPercentagePDV(double percentagePDV) {
        this.percentagePDV = percentagePDV;
    }


    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }


    public Article getArticle() {
        return article;
    }


    public void setArticle(Article article) {
        this.article = article;
    }


    public boolean isActive() {
        return active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

}

