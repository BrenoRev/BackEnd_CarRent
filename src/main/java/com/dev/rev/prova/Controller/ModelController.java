package com.dev.rev.prova.Controller;

import com.dev.rev.prova.Entities.Model;
import com.dev.rev.prova.Exceptions.classes.NotFound.ModelNotFoundException;
import com.dev.rev.prova.Services.ModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Model's API")
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/model")
@RestController
public class ModelController {

    @Autowired
    private ModelService modelService;

    @ApiOperation(value = "Get models by brand")
    @GetMapping(value = "/{brand}", produces = "application/json")
    public ResponseEntity<List<Model>> getModelByBrand(@PathVariable("brand") String brand) throws ModelNotFoundException {
        return modelService.getByBrand(brand);
    }

    @ApiOperation(value = "Get all models of cars")
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Model>> getAllModels(){
        return modelService.getAllModels();
    }

}
