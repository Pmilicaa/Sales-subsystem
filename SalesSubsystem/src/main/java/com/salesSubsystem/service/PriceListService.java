package com.salesSubsystem.service;

import com.salesSubsystem.model.PriceList;
import com.salesSubsystem.repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceListService {

    @Autowired
    private PriceListRepository priceListRepository;

    public PriceList getPriceList(Long id){
        PriceList priceList = priceListRepository.findById(id).orElseThrow(NullPointerException::new);
        return priceList;
    }
    public List<PriceList> getAllPriceLists(){
        return priceListRepository.findAll();
    }
    
    public PriceList savePriceList(PriceList priceList) {
    	return priceListRepository.save(priceList);
    }
}
