package com.dev.rev.prova.Services;

import com.dev.rev.prova.Entities.Model;
import com.dev.rev.prova.Repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public ResponseEntity<List<Model>> getByBrand(String brand){
        return new ResponseEntity<List<Model>>(modelRepository.getAllByBrand(brand), HttpStatus.OK);
    }

    public ResponseEntity<List<Model>> getAllModels(){
        return new ResponseEntity<List<Model>>(modelRepository.findAll(), HttpStatus.OK);
    }
}
