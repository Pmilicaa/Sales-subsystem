package com.salesSubsystem.repository;

import com.salesSubsystem.model.ArticleGroup;
import com.salesSubsystem.model.PDV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PDVRepository extends JpaRepository<PDV,Long> {
    PDV findByArticleGroups(ArticleGroup articleGroup);
}
