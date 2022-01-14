package com.dev.rev.prova.services;

import com.dev.rev.prova.entities.Brand;
import com.dev.rev.prova.entities.Model;
import com.dev.rev.prova.exceptions.classes.notfound.ModelNotFoundException;
import com.dev.rev.prova.repositories.BrandRepository;
import com.dev.rev.prova.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ModelService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Cacheable("model")
    public ResponseEntity<List<Model>> getByBrand(String brand) throws ModelNotFoundException {
            List<Model> models = modelRepository.getAllByBrand(brand);

            if(models.isEmpty()){
                throw new ModelNotFoundException("That brand doesn't have any models");
            }
            return new ResponseEntity<>(models, HttpStatus.OK);

    }

    @Cacheable("model")
    public ResponseEntity<List<Model>> getAllModels(){
        return new ResponseEntity<>(modelRepository.findAll(), HttpStatus.OK);
    }
    @CacheEvict(value = "model", allEntries = true)
    public ResponseEntity<List<Model>> saveModels(List<Model> models, String name){
        Brand brand = brandRepository.findByName(name);
        models.forEach(x -> x.setBrand(brand));
        return new ResponseEntity<>(modelRepository.saveAll(models),HttpStatus.OK);
    }
}
