package com.dev.rev.prova.Unit.Services;

import com.dev.rev.prova.Entities.Brand;
import com.dev.rev.prova.Unit.Repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Cacheable("brand")
    public ResponseEntity<List<Brand>> getAllBrands(){
        return new ResponseEntity<List<Brand>>(brandRepository.findAll(), HttpStatus.OK);
    }

    @CacheEvict(value = "brand", allEntries = true)
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand){
        return new ResponseEntity<Brand>(brandRepository.save(brand), HttpStatus.OK);
    }


}
