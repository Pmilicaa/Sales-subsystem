package com.salesSubsystem.repository;

import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByInvoiceItems_Id(Long invoiceItemId);
}
