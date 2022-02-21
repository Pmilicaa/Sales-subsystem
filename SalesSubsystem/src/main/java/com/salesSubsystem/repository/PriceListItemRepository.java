package com.salesSubsystem.repository;

import com.salesSubsystem.model.PriceListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceListItemRepository extends JpaRepository<PriceListItem,Long> {
    PriceListItem findByPrice(double price);
    PriceListItem findByArticleId(long id);
}
