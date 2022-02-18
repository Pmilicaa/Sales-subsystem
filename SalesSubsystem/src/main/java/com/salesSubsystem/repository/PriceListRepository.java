package com.salesSubsystem.repository;

import com.salesSubsystem.model.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceListRepository extends JpaRepository<PriceList,Long> {
    PriceList findByPricePerUnit(double price);
}
