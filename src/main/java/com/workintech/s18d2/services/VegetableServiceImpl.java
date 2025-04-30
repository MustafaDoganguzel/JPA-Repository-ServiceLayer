package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VegetableServiceImpl implements VegetableService{
    private final VegetableRepository vr;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vr){
        this.vr = vr;
    }


    @Override
    public List<Vegetable> getByPriceDesc() {
        return vr.getByPriceDesc();
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vr.getByPriceAsc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vr.searchByName(name);
    }


    public Vegetable save(Vegetable vegetable){
        return vr.save(vegetable);
    }

    public Vegetable getById(Long id){
        Optional<Vegetable> vegetableOptional = vr.findById(id);
        if(vegetableOptional.isPresent()){
            return vegetableOptional.get();
        }else{
            throw new RuntimeException("DEGISECEK"); // degistirilecek
        }

    }

    public Vegetable delete(Long id){
        Vegetable found = vr.getById(id);
        vr.delete(found);
        return found;
    }
}
