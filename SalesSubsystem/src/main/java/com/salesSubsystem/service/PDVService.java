package com.salesSubsystem.service;

import com.salesSubsystem.model.ArticleGroup;
import com.salesSubsystem.model.OutputInvoice;
import com.salesSubsystem.model.PDV;
import com.salesSubsystem.repository.PDVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PDVService {

    @Autowired
    private PDVRepository pdvRepository;

    public List<PDV> getAll() {
        return pdvRepository.findAll();
    }

    public PDV getPDV(Long id) {
        return pdvRepository.findById(id).get();
    }

    public PDV getPDVByArticleGroup(ArticleGroup articleGroup) {
        return pdvRepository.findByArticleGroups(articleGroup);
    }

    public PDV save(PDV pdv) {
        return pdvRepository.save(pdv);
    }

}
