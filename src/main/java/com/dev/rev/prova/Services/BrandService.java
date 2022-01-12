package com.dev.rev.prova.Services;

import com.dev.rev.prova.Entities.Brand;
import com.dev.rev.prova.Repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public ResponseEntity<List<Brand>> getAllBrands(){
        return new ResponseEntity<List<Brand>>(brandRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand){
        return new ResponseEntity<Brand>(brandRepository.save(brand), HttpStatus.OK);
    }


}
