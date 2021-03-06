package com.salesSubsystem.service;

import com.salesSubsystem.model.UnitOfMeasure;
import com.salesSubsystem.repository.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitOfMeasureService {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public List<UnitOfMeasure> getAllUnitOfMeasures(){
        return unitOfMeasureRepository.findAll();
    }

    public UnitOfMeasure getUnitOfMeasure(Long id){
        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findById(id).orElseThrow(NullPointerException::new);
        return unitOfMeasure;
    }

    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure){
        return unitOfMeasureRepository.save(unitOfMeasure);
    }

    public void delete(UnitOfMeasure unitOfMeasure){
        unitOfMeasureRepository.delete(unitOfMeasure);
    }
    public UnitOfMeasure getUnitOfMeasureByShortName(String name){
        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findByShortName(name);
        return unitOfMeasure;
    }
}
