package com.salesSubsystem.controller;

import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.PriceList;
import com.salesSubsystem.service.ArticleService;
import com.salesSubsystem.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PriceListController {

    @Autowired
    private PriceListService priceListService;
    
    @Autowired
    private ArticleService articleService;

    @GetMapping(path="/priceLists")
    private ResponseEntity<List<PriceList>> getPriceLists(){
        return new ResponseEntity<List<PriceList>>(priceListService.getAllPriceLists(), HttpStatus.OK);
    }

    @GetMapping(path="/priceLists/{id}")
    private ResponseEntity<PriceList> getPriceList(Long id){
        PriceList pl = priceListService.getPriceList(id);
        if(pl == null){
            return new ResponseEntity<PriceList>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<PriceList>(pl, HttpStatus.OK);
    }
    
    @PostMapping(path="/articles/{articleId}/priceListes")
    private @ResponseBody ResponseEntity<?> savePriceList(@RequestBody PriceList priceList, @PathVariable("articleId") Long articleId) {
    	Article article = articleService.getArticle(articleId);
    	if (article == null) {
    		return new ResponseEntity(HttpStatus.NOT_FOUND);
    	}
    	priceList.setArticle(article);
    	priceList = priceListService.savePriceList(priceList);
    	return new ResponseEntity(priceList, HttpStatus.OK);
    }
    
}
