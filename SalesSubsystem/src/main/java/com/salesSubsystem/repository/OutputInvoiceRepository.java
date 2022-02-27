package com.salesSubsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesSubsystem.model.OutputInvoice;

import java.util.List;

public interface OutputInvoiceRepository extends JpaRepository<OutputInvoice, Long>{
    List<OutputInvoice> findByReleaseDateBetween(Long beginning, Long ending);
}
