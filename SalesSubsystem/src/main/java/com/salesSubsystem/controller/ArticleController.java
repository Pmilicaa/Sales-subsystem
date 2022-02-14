package com.salesSubsystem.controller;

import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.PriceList;
import com.salesSubsystem.repository.ArticleRepository;
import com.salesSubsystem.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/articles")
    public @ResponseBody ResponseEntity<List<Article>> getAllArticles(){
        return new ResponseEntity<List<Article>>(articleService.getAllArticles(), HttpStatus.OK);
    }
    @GetMapping(path="/articles/{id}")
    public @ResponseBody ResponseEntity<Article> getArticle(@PathVariable("id") Long id){
        Optional<Article> articleOptional = articleRepository.findById(id);
        if(articleOptional.isPresent()){
            return new ResponseEntity<Article>(articleOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);

    }
    @PostMapping(path="/articles")
    public ResponseEntity<Article> addArticle(@RequestBody Article article){
        Article newArticle = new Article(article.getName(), article.getDescription(), article.getUnitOfMeasure(), article.getPriceLists(), article.getArticleGroup(),
                article.getInvoiceItems(), article.getCompany());
        return new ResponseEntity<Article>(articleService.saveArticle(newArticle), HttpStatus.OK);
    }
    @DeleteMapping(path="/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id ){
        Optional<Article> articleOptional = articleRepository.findById(id);
        if(articleOptional.isPresent()){
            articleService.logicalDeleteArticle(articleOptional.get());
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
}
