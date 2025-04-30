package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fs;

    @Autowired
    public FruitController(FruitService fs){
        this.fs = fs;
    }

    @GetMapping
    public List<Fruit> getByPriceAsc(){
        return fs.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit findById(@PathVariable Long id){
        return fs.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getByPriceDec(){
        return fs.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit){
        fs.save(fruit);
        return fruit;
    }

    @GetMapping("/name/{name}")
    public List<Fruit> searchByName(@PathVariable String name){
     return  fs.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id){
        return fs.delete(id);
    }
}
