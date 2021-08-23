package com.salesSubsystem.controller;

import com.salesSubsystem.model.PriceList;
import com.salesSubsystem.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PriceListController {

    @Autowired
    private PriceListService priceListService;

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
}
