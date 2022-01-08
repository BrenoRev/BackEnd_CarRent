package com.dev.rev.prova.Controller;

import com.dev.rev.prova.Entities.Model;
import com.dev.rev.prova.Services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/model")
@RestController
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/{brand}")
    public ResponseEntity<List<Model>> getModelByBrand(@PathVariable("brand") String brand){
        return modelService.getByBrand(brand);
    }

    @GetMapping("/")
    public ResponseEntity<List<Model>> getAllModels(){
        return modelService.getAllModels();
    }

}
