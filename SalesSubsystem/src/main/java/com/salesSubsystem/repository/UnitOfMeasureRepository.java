package com.salesSubsystem.repository;

import com.salesSubsystem.model.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure,Long> {
    UnitOfMeasure findByShortName(String shortName);
}
