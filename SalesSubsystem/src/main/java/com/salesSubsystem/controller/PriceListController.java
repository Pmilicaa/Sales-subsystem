package com.salesSubsystem.controller;

import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.PriceList;
import com.salesSubsystem.model.PriceListItem;
import com.salesSubsystem.repository.PriceListRepository;
import com.salesSubsystem.service.ArticleService;
import com.salesSubsystem.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class PriceListController {

    @Autowired
    private PriceListService priceListService;

    @Autowired
    private PriceListRepository priceListRepository;

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/priceLists")
    private ResponseEntity<List<PriceList>> getPriceLists(){
        return new ResponseEntity<List<PriceList>>(priceListService.getAllPriceLists(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/priceLists/{id}")
    private ResponseEntity<PriceList> getPriceList(@PathVariable("id") Long id){
        PriceList pl = priceListService.getPriceList(id);
        if(pl == null){
            return new ResponseEntity<PriceList>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<PriceList>(pl, HttpStatus.OK);
    }
    
}
