package com.dev.rev.prova.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EnumType;
import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev.rev.prova.entities.Car;
import com.dev.rev.prova.enums.CarColor;
import com.dev.rev.prova.enums.CarFuel;
import com.dev.rev.prova.enums.CarTransmission;
import com.dev.rev.prova.enums.CarType;
import com.dev.rev.prova.exceptions.classes.notfound.CarNotFoundException;
import com.dev.rev.prova.repositories.CarRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@AllArgsConstructor
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Cacheable("car")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
    }

    @Cacheable("car")
    public ResponseEntity<Car> getById(Long id) throws CarNotFoundException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car with id " + id + " not found"));
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @Cacheable("car")
    public ResponseEntity<Page<Car>> getPage(Pageable pageable) {
        Page<Car> pageCars = carRepository.findAll(pageable);
        return new ResponseEntity<>(pageCars, HttpStatus.OK);
    }

    @Transactional
    @CacheEvict(value = "car", allEntries = true)
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Modifying
    @ResponseStatus(HttpStatus.OK)
    @CacheEvict(value = "car", allEntries = true)
    public void deleteCarById(Long id) throws CarNotFoundException {
        try {
            carRepository.deleteById(id);
        } catch (Exception excep) {
            throw new CarNotFoundException("Car with id " + id + " doesn't exists");
        }
    }

    @Modifying
    @Transactional
    @CacheEvict(value = "car", allEntries = true)
    public ResponseEntity<Car> update(Long id, Car car) throws CarNotFoundException {
        if(carRepository.findById(id).isPresent()) {
            car.setId(id);
            car.getModel().setBrand(car.getBrand());
            return new ResponseEntity<>(carRepository.save(car), HttpStatus.ACCEPTED);
        }
        else{
            throw new CarNotFoundException("Car with this id wasn't found");
        }
    }

    @Modifying
    @Transactional
    @CacheEvict(value = "car", allEntries = true)
    public ResponseEntity<Car> patch(Long id, Map<Object, Object> fields) throws CarNotFoundException {

        final String CAR_COLOR = "carColor";
        final String CAR_TYPE = "carType";
        final String CAR_TRANSMISSION = "carTransmission";
        final String CAR_FUEL = "carFuel";
        Optional<Car> carro = carRepository.findById(id);
        if (carro.isPresent()) {
            Car carObject = carro.get();

            if (fields.containsKey(CAR_COLOR)) {
                carObject.setCarColor(EnumType.valueOf(CarColor.class, fields.get(CAR_COLOR).toString().toUpperCase()));
                fields.remove(CAR_COLOR);
                }
            if(fields.containsKey(CAR_TYPE)){
                carObject.setCarType(EnumType.valueOf(CarType.class, fields.get(CAR_TYPE).toString().toUpperCase()));
                fields.remove(CAR_TYPE);
                }
            if(fields.containsKey(CAR_TRANSMISSION)){
                carObject.setCarTransmission(EnumType.valueOf(CarTransmission.class, fields.get(CAR_TRANSMISSION).toString().toUpperCase()));
                fields.remove(CAR_TRANSMISSION);
                }
            if(fields.containsKey(CAR_FUEL)){
                carObject.setCarFuel(EnumType.valueOf(CarFuel.class, fields.get(CAR_FUEL).toString().toUpperCase()));
                fields.remove(CAR_FUEL);
                }


            fields.forEach((x, y) -> {
                    Field field = ReflectionUtils.findRequiredField(Car.class, x.toString());
                    field.setAccessible(true);

                    ReflectionUtils.setField(field, carObject, y);
                });
            carRepository.save(carObject);
            return new ResponseEntity<>(carObject, HttpStatus.OK);
        }

        throw new CarNotFoundException("Car with that id wasn't found");
    }


}
