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
    public double getPriceWithPDV (double price, long pdv, String pdv_type){
         double percent = (price * pdv) / 100;
         if(pdv_type.equals("increase")){
             price +=percent;
         }else if(pdv_type.equals("decrease")){
             price-=percent;
         }
         return price;
    };
    public List<PriceList> getAllPriceLists(){
        return priceListRepository.findAll();
    }
    
    public PriceList savePriceList(PriceList priceList) {
    	return priceListRepository.save(priceList);
    }
}
