package com.salesSubsystem.controller;

import com.salesSubsystem.model.UnitOfMeasure;
import com.salesSubsystem.service.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnitOfMeasureController {

    @Autowired
    private UnitOfMeasureService unitOfMeasureService;

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/unitOfMeasures")
    public ResponseEntity<List<UnitOfMeasure>> getAllUnitOfMeasures(){
        return new ResponseEntity<List<UnitOfMeasure>>(unitOfMeasureService.getAllUnitOfMeasures(), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/unitOfMeasures/{id}")
    public ResponseEntity<UnitOfMeasure> getUnitOfMeasure(@PathVariable Long id){
        UnitOfMeasure unitOfMeasure = unitOfMeasureService.getUnitOfMeasure(id);
        if(unitOfMeasure == null){
            return new ResponseEntity<UnitOfMeasure>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UnitOfMeasure>(unitOfMeasure, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping(path="/unitOfMeasure/{shortName}")
    public ResponseEntity<UnitOfMeasure> getUnitByName(@PathVariable String shortName){
        UnitOfMeasure unitOfMeasure = unitOfMeasureService.getUnitOfMeasureByShortName(shortName);
        if(unitOfMeasure == null){
            return new ResponseEntity<UnitOfMeasure>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UnitOfMeasure>(unitOfMeasure, HttpStatus.OK);
    }
}
