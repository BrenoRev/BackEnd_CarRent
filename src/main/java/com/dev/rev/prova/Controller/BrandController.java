package com.dev.rev.prova.Controller;

import com.dev.rev.prova.Entities.Brand;
import com.dev.rev.prova.Services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/brand")
@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("/")
    public ResponseEntity<List<Brand>> getAllBrands(){
        return brandService.getAllBrands();
    }
}
