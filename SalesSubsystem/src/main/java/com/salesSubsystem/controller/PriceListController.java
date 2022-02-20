package com.salesSubsystem.controller;

import com.salesSubsystem.dto.ArticlePriceDto;
import com.salesSubsystem.dto.PriceListDto;
import com.salesSubsystem.dto.PriceListItemDto;
import com.salesSubsystem.dto.PriceListRequestDto;
import com.salesSubsystem.dto.PriceListResponseDto;
import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.Company;
import com.salesSubsystem.model.PriceList;
import com.salesSubsystem.model.PriceListItem;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
public class PriceListController {

    @Autowired
    private PriceListService priceListService;

    @Autowired
    private PriceListItemService priceListItemService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private PriceListRepository priceListRepository;

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/priceLists")
    private ResponseEntity<List<PriceListDto>> getPriceLists(){
        List<PriceList> lists =priceListService.getAllPriceLists();
        List<PriceListDto> listDtos = new ArrayList<>();
        for(PriceList list : lists){
            PriceListDto listDto = new PriceListDto(list.getId(), list.getValidFrom(), list.getCompany().getPIB());
            listDtos.add(listDto);
        }
        return new ResponseEntity<List<PriceListDto>>(listDtos, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/priceLists/company")
    private ResponseEntity<List<PriceListResponseDto>> getPriceListsByCompany(){
        List<PriceList> priceLists = priceListService.getAllPriceLists();
        List<Article> articles = articleService.getAllArticles();
        List<PriceListResponseDto>  listsDto = new ArrayList<>();
        for(PriceList list : priceLists){
            for(PriceListItem item: list.getItems()){
                PriceListResponseDto newDto = new PriceListResponseDto(list.getValidFrom(),
                        item.getPrice(),
                        item.getArticle().getName(),
                        item.getArticle().getArticleGroup().getName(), item.getArticle().getCompany().getPIB());
                listsDto.add(newDto);
            }
        }
        return new ResponseEntity<List<PriceListResponseDto>>(listsDto, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/priceLists/{id}")
    private ResponseEntity<List<PriceListResponseDto>> getPriceList(@PathVariable("id") long id){
        List<PriceList> priceLists = priceListService.getAllPriceLists();
        PriceList priceList = priceListService.getPriceList(id);
        List<Article> articles = articleService.getAllArticles();
        List<PriceListResponseDto>  listsDto = new ArrayList<>();
        for(PriceListItem item : priceList.getItems()){
                PriceListResponseDto newDto = new PriceListResponseDto(priceList.getValidFrom(),
                        item.getPrice(),
                        item.getArticle().getName(),
                        item.getArticle().getArticleGroup().getName(), item.getArticle().getCompany().getPIB());
                listsDto.add(newDto);

        }
        return new ResponseEntity<List<PriceListResponseDto>>(listsDto, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @PostMapping(path="/priceLists")
    public ResponseEntity<PriceList> addPriceList(@RequestBody PriceListRequestDto priceListDto){
        System.out.print(priceListDto.toString());
        List<PriceListItem> lists = new ArrayList<>();
        Company company = null;
        for(ArticlePriceDto articlePriceDto : priceListDto.getArticlePriceList()){
            Article article = articleService.getArticle(articlePriceDto.getArticleId());
            PriceListItem item = new PriceListItem(articlePriceDto.getPrice(), article);
            PriceListItem savedItem = priceListItemService.savePriceListItem(item);
            article.setPriceListItem(savedItem);
            articleService.saveArticle(article);
            lists.add(savedItem);
            company = article.getCompany();
        }
        PriceList priceList= new PriceList(System.currentTimeMillis(),lists,company);
        priceListService.savePriceList(priceList);
        return new ResponseEntity<PriceList>(priceList,HttpStatus.OK);
    }
    
}
