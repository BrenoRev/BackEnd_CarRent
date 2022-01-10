package com.dev.rev.prova.Services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EnumType;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev.rev.prova.Entities.Car;
import com.dev.rev.prova.Enums.CarColor;
import com.dev.rev.prova.Enums.CarFuel;
import com.dev.rev.prova.Enums.CarTransmission;
import com.dev.rev.prova.Enums.CarType;
import com.dev.rev.prova.Exceptions.classes.NotFound.CarNotFoundException;
import com.dev.rev.prova.Repositories.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<List<Car>>(carRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Car> getById(Long id) throws CarNotFoundException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car with id " + id + " not found"));
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @Transactional
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Modifying
    public ResponseEntity<String> deleteCarById(Long id) throws CarNotFoundException {
        try {
            carRepository.deleteById(id);
        } catch (Exception excep) {
            throw new CarNotFoundException("Car with id " + id + " doesn't exists");
        }
        return new ResponseEntity<String>("Car has been deleted sucessfully", HttpStatus.OK);
    }

    @Modifying
    @Transactional
    public ResponseEntity<Car> update(Long id, Car car) throws CarNotFoundException {
        if(carRepository.findById(id).isPresent()) {
            car.setId(id);
            return new ResponseEntity<Car>(carRepository.save(car), HttpStatus.ACCEPTED);
        }
        else{
            throw new CarNotFoundException("Car with this id wasn't found");
        }
    }

    @Modifying
    @Transactional
    public ResponseEntity<Car> patch(Long id, Map<Object, Object> fields) throws CarNotFoundException {

        Optional<Car> carro = carRepository.findById(id);
        if (carro.isPresent()) {
            Car carObject = carro.get();

            // TODO: RESOLVER PROBLEMA COM O REFLECTIONS NÃO CONSEGUINDO INTERAR OS ENUMS

            if (fields.containsKey("carColor")) {
                carObject.setCarColor(EnumType.valueOf(CarColor.class, fields.get("carColor").toString().toUpperCase()));
                fields.remove("carColor");
                }
            if(fields.containsKey("carType")){
                carObject.setCarType(EnumType.valueOf(CarType.class, fields.get("carType").toString().toUpperCase()));
                fields.remove("carType");
                }
            if(fields.containsKey("carTransmission")){
                carObject.setCarTransmission(EnumType.valueOf(CarTransmission.class, fields.get("carTransmission").toString().toUpperCase()));
                fields.remove("carTransmission");
                }
            if(fields.containsKey("carFuel")){
                carObject.setCarFuel(EnumType.valueOf(CarFuel.class, fields.get("carFuel").toString().toUpperCase()));
                fields.remove("carFuel");
                }


            fields.forEach((x, y) -> {
                    Field field = ReflectionUtils.findRequiredField(Car.class, x.toString());
                    field.setAccessible(true);

                    ReflectionUtils.setField(field, carObject, y);
                });
            carRepository.save(carObject);
            return new ResponseEntity<Car>(carObject, HttpStatus.OK);
        }

        throw new CarNotFoundException("Car with that id wasn't found");
    }

    public ResponseEntity<Page<Car>> getPage(Pageable pageable) {
        Page<Car> pageCars = carRepository.findAll(pageable);
        return new ResponseEntity<Page<Car>>(pageCars, HttpStatus.OK);
    }
}
