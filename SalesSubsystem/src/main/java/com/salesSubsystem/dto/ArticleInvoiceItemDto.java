package com.salesSubsystem.dto;

import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.InvoiceItem;

public class ArticleInvoiceItemDto {
    private Article article;
    private InvoiceItem invoiceItem;

    public ArticleInvoiceItemDto(Article article, InvoiceItem invoiceItem) {
        this.article = article;
        this.invoiceItem = invoiceItem;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public InvoiceItem getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(InvoiceItem invoiceItem) {
        this.invoiceItem = invoiceItem;
    }
}
