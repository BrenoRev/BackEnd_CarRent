package com.dev.rev.prova.Controller;

import com.dev.rev.prova.Entities.Car;
import com.dev.rev.prova.Exceptions.classes.NotFound.CarNotFoundException;
import com.dev.rev.prova.Services.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Map;

@Api(value = "Car's API")
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/car")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @ApiOperation(value = "Get car by id")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Car> getById(@PathVariable("id") Long id) throws CarNotFoundException {
        return carService.getById(id);
    }

    @ApiOperation(value = "Get all cars")
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Car>> getAllCars(){
        return carService.getAllCars();
    }

    @ApiOperation(value = "Save a car")
    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Car> saveCar(@Valid @RequestBody Car car){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/car/id_created").toUriString());
        return ResponseEntity.created(uri).body(carService.saveCar(car));
    }

    @ApiOperation(value = "Delete a car")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable("id") Long id) throws CarNotFoundException {
        return carService.deleteCarById(id);
    }

    @ApiOperation(value = "Update a car")
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @Valid @RequestBody Car car){
        return carService.update(id, car);
    }

    @ApiOperation(value = "Patch char update")
    @PatchMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Car> patchCar(@PathVariable("id") Long id, @Valid @RequestBody Map<Object, Object> fields){
        return carService.patch(id, fields);
    }

    @ApiOperation(value = "Pagination car's search")
    @GetMapping(value = "/pagination", produces = "application/json")
    public ResponseEntity<Page<Car>> getCarsByPage(@PageableDefault(direction = Sort.Direction.DESC, size = 10, sort = "price") Pageable pageable){
        return carService.getPage(pageable);
    }
}
