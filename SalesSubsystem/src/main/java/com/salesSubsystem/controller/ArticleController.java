package com.salesSubsystem.controller;

import com.salesSubsystem.dto.ArticleDto;
import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.ArticleGroup;
import com.salesSubsystem.model.Company;
import com.salesSubsystem.model.PriceList;
import com.salesSubsystem.model.PriceListItem;
import com.salesSubsystem.model.UnitOfMeasure;
import com.salesSubsystem.repository.ArticleRepository;
import com.salesSubsystem.service.ArticleGroupService;
import com.salesSubsystem.service.ArticleService;
import com.salesSubsystem.service.CompanyService;
import com.salesSubsystem.service.PriceListItemService;
import com.salesSubsystem.service.PriceListService;
import com.salesSubsystem.service.UnitOfMeasureService;
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

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ArticleGroupService articleGroupService;

    @Autowired
    private UnitOfMeasureService unitOfMeasureService;

    @Autowired
    private PriceListItemService priceListItemService;

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
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @PostMapping(path="/articles")
    public ResponseEntity<Article> addArticle(@RequestBody ArticleDto articleDto){
        ArticleGroup articleGroup = articleGroupService.getArticleGroup(articleDto.getGroup());
        UnitOfMeasure unit = unitOfMeasureService.getUnitOfMeasure(articleDto.getUom());
        Company company = companyService.getCompanyByPib(articleDto.getPib());
        PriceListItem priceListItem = new PriceListItem(articleDto.getPrice(),null);
        Article article = new Article(articleDto.getName(), articleDto.getDescription(), unit, priceListItem, articleGroup, null, company);
        Article newArticle = articleRepository.save(article);
        priceListItem.setArticle(newArticle);
        priceListItemService.savePriceListItem(priceListItem);
        PriceListItem item = priceListItemService.getPriceListItemByArticle(newArticle);
        newArticle.setPriceListItem(item);
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
