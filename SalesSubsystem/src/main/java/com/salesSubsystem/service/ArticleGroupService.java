package com.salesSubsystem.service;

import com.salesSubsystem.model.ArticleGroup;
import com.salesSubsystem.repository.ArticleGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleGroupService {

    @Autowired
    private ArticleGroupRepository articleGroupRepository;

    public List<ArticleGroup> getAllArticleGroups(){
        return articleGroupRepository.findAll();
    }
    public ArticleGroup getArticleGroup(Long id){
        ArticleGroup articleGroup = articleGroupRepository.findById(id).orElseThrow(NullPointerException::new);
        return articleGroup;
    }
    public ArticleGroup saveArticleGroup(ArticleGroup group){
        articleGroupRepository.save(group);
        return group;
    }
    public ArticleGroup getArticleGroupByName(String name){
        ArticleGroup articleGroup = articleGroupRepository.findByName(name);
        return articleGroup;
    }
}
