package com.salesSubsystem.controller;


import com.salesSubsystem.dto.ArticleGroupDto;
import com.salesSubsystem.dto.PriceListItemDto;
import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.ArticleGroup;
import com.salesSubsystem.model.Company;
import com.salesSubsystem.model.PriceList;
import com.salesSubsystem.model.PriceListItem;
import com.salesSubsystem.repository.PriceListItemRepository;
import com.salesSubsystem.repository.PriceListRepository;
import com.salesSubsystem.service.ArticleService;
import com.salesSubsystem.service.PriceListItemService;
import com.salesSubsystem.service.PriceListService;
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
import java.util.List;

@RestController
public class PriceListItemController {
    @Autowired
    private PriceListItemService priceListItemService;

    @Autowired
    private ArticleService articleService;
    @Autowired
    private PriceListService priceListService;

    @Autowired
    private PriceListItemRepository priceListItemRepository;

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/priceListItems")
    private ResponseEntity<List<PriceListItem>> getPriceListItems(){
        return new ResponseEntity<List<PriceListItem>>(priceListItemService.getAllPriceListItems(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/priceListItems/{id}")
    private ResponseEntity<PriceListItem> getPriceListItem(@PathVariable("id") Long id){
        PriceListItem pl = priceListItemService.getPriceListItem(id);
        if(pl == null){
            return new ResponseEntity<PriceListItem>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<PriceListItem>(pl, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @PostMapping(path="/priceListItems")
    public ResponseEntity<PriceListItem> addPriceItem(@RequestBody PriceListItemDto itemDto){
        Article article =articleService.getArticle(itemDto.getId());
        PriceListItem item = new PriceListItem(itemDto.getPrice(), article);
        PriceListItem savedItem = priceListItemService.savePriceListItem(item);
        article.setPriceListItem(savedItem);
        articleService.saveArticle(article);
        return new ResponseEntity<PriceListItem>(savedItem, HttpStatus.OK);
    }
}
