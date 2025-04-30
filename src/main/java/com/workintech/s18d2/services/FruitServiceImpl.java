package com.workintech.s18d2.services;

import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public class FruitServiceImpl implements FruitService{

    private final FruitRepository fr;
    @Autowired
    public FruitServiceImpl(FruitRepository fr){
        this.fr = fr;
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fr.getByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fr.getByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fr.searchByName(name);
    }
    @Override
    public Fruit save(Fruit fruit){
        return fr.save(fruit);
    }
    @Override
    public Fruit delete(Long id){
        Fruit found = getById(id);
        fr.delete(found);
        return found;
    }
    @Override
    public Fruit getById(Long id){

        Optional<Fruit> fruitOptional = fr.findById(id);
        if (fruitOptional.isPresent()){
            return fruitOptional.get();
        }
        throw new PlantException("Fruit couldnt be found" + id, HttpStatus.NOT_FOUND);
    }


}
