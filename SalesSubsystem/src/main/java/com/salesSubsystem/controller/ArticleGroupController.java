package com.salesSubsystem.controller;

import com.salesSubsystem.dto.ArticleDto;
import com.salesSubsystem.dto.ArticleGroupDto;
import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.ArticleGroup;
import com.salesSubsystem.model.Company;
import com.salesSubsystem.model.PDV;
import com.salesSubsystem.model.PriceList;
import com.salesSubsystem.model.UnitOfMeasure;
import com.salesSubsystem.service.ArticleGroupService;
import com.salesSubsystem.service.ArticleService;
import com.salesSubsystem.service.CompanyService;
import com.salesSubsystem.service.PDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ArticleGroupController {

    @Autowired
    private ArticleGroupService articleGroupService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PDVService pdvService;

    @Autowired
    private ArticleService articleService;

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/articleGroups")
    public ResponseEntity<List<ArticleGroup>> getAllUnitOfMeasures(){
        return new ResponseEntity<List<ArticleGroup>>(articleGroupService.getAllArticleGroups(), HttpStatus.OK);
    }
    @GetMapping(path="/articleGroups/{id}")
    public ResponseEntity<ArticleGroup> getUnitOfMeasure(@PathVariable Long id){
        ArticleGroup articleGroup = articleGroupService.getArticleGroup(id);
        if(articleGroup == null){
            return new ResponseEntity<ArticleGroup>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ArticleGroup>(articleGroup, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @PostMapping(path="/addArticleGroups")
    public ResponseEntity<ArticleGroup> addArticleGroups(@RequestBody ArticleGroupDto articleGroupDto){
        Company company = companyService.getCompanyByPib(articleGroupDto.getPib());
        List<Article> articles = new ArrayList<>();
        List<PDV> pdvs = new ArrayList<>();
        ArticleGroup group = new ArticleGroup(articleGroupDto.getName(),pdvs);
        return new ResponseEntity<ArticleGroup>(articleGroupService.saveArticleGroup(group), HttpStatus.OK);
    }
}
