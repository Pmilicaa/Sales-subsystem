package com.salesSubsystem.repository;

import com.salesSubsystem.model.ArticleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleGroupRepository extends JpaRepository<ArticleGroup, Long>{
    ArticleGroup findByName(String name);
}
