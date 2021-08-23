package com.salesSubsystem.controller;

import com.salesSubsystem.model.ArticleGroup;
import com.salesSubsystem.model.UnitOfMeasure;
import com.salesSubsystem.service.ArticleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleGroupController {

    @Autowired
    private ArticleGroupService articleGroupService;

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
}
