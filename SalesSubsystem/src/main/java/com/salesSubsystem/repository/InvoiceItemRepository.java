package com.salesSubsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesSubsystem.model.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long>{

}
