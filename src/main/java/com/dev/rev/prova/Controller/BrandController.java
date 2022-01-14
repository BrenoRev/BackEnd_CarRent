package com.dev.rev.prova.Controller;

import com.dev.rev.prova.Entities.Brand;
import com.dev.rev.prova.Services.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Brand's API")
@CrossOrigin("*")
@RequestMapping("/api/v1/brand")
@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    @ApiOperation(value = "Get all brands")
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Brand>> getAllBrands(){
        return brandService.getAllBrands();
    }

    @ApiOperation(value = "Save brand of cars")
    @PostMapping("/")
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand){
        return brandService.saveBrand(brand);
    }
}
