package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private final VegetableService vs;

    @Autowired
    public VegetableController(VegetableService vs){
        this.vs = vs;
    }

    @GetMapping
    public List<Vegetable> getByPriceAsc(){
        return vs.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable findById(@PathVariable Long id){

        return vs.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getByPriceDec(){
        return vs.getByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable){
        vs.save(vegetable);
        return vegetable;
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> searchByName(@PathVariable String name){
        return  vs.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id){
        return vs.delete(id);
    }
}
