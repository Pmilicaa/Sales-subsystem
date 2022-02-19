package com.salesSubsystem.service;

import com.salesSubsystem.model.Article;
import com.salesSubsystem.model.PriceListItem;
import com.salesSubsystem.repository.PriceListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceListItemService {
    @Autowired
    private PriceListItemRepository priceListItemRepository;

    public PriceListItem getPriceListItem(Long id){
        PriceListItem priceListItem = priceListItemRepository.findById(id).orElseThrow(NullPointerException::new);
        return priceListItem;
    }
    public PriceListItem getPriceListItemByArticle(Article article){
        PriceListItem priceListItem = priceListItemRepository.findByArticleId(article.getId());
        return priceListItem;
    }
    public PriceListItem getPriceListItemByPrice(double price){
        PriceListItem priceItem = priceListItemRepository.findByPrice(price);
        return priceItem;
    }
    public List<PriceListItem> getAllPriceListItems(){
        return priceListItemRepository.findAll();
    }

    public PriceListItem savePriceListItem(PriceListItem priceList) {
        return priceListItemRepository.save(priceList);
    }
}
