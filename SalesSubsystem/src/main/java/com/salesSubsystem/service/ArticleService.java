package com.salesSubsystem.service;

import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.PriceList;
import com.salesSubsystem.repository.ArticleRepository;
import com.salesSubsystem.repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private PriceListRepository priceListRepository;

    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }
    public Article getArticle(Long id){
        return articleRepository.findById(id).get();
    }
    public Article saveArticle(Article article){
        articleRepository.save(article);
        return article;
    }
    public Article logicalDeleteArticle(Article article){
        article.setActive(false);
        return articleRepository.save(article);
    }
}
