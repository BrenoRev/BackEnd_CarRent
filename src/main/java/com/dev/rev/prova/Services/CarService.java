package com.dev.rev.prova.Services;

import com.dev.rev.prova.Entities.Car;
import com.dev.rev.prova.Enums.CarColor;
import com.dev.rev.prova.Enums.CarFuel;
import com.dev.rev.prova.Enums.CarTransmission;
import com.dev.rev.prova.Enums.CarType;
import com.dev.rev.prova.Exceptions.classes.NotFound.CarNotFoundException;
import com.dev.rev.prova.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Modifying
    @Transactional
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Modifying
    @Transactional
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
    public ResponseEntity<Car> update(Long id, Car car) {
        car.setId(id);
        return new ResponseEntity<Car>(carRepository.save(car), HttpStatus.ACCEPTED);
    }

    @Modifying
    @Transactional
    public ResponseEntity<Car> patch(Long id, Map<Object, Object> fields) {

        Optional<Car> carro = carRepository.findById(id);
        if (carro.isPresent()) {
            Car carObject = carro.get();

            // TODO: RESOLVER PROBLEMA COM O REFLECTIONS NÃO CONSEGUINDO INTERAR OS ENUMS

            if (fields.containsKey("color")) {
                carObject.setColor(EnumType.valueOf(CarColor.class, fields.get("color").toString()));
                fields.remove("color");
                }
            if(fields.containsKey("carType")){
                carObject.setCarType(EnumType.valueOf(CarType.class, fields.get("carType").toString()));
                fields.remove("carType");
                }
            if(fields.containsKey("carTransmission")){
                carObject.setCarTransmission(EnumType.valueOf(CarTransmission.class, fields.get("carTransmission").toString()));
                fields.remove("carTransmission");
                }
            if(fields.containsKey("fuel")){
                carObject.setFuel(EnumType.valueOf(CarFuel.class, fields.get("fuel").toString()));
                fields.remove("fuel");
                }


            fields.forEach((x, y) -> {
                    Field field = ReflectionUtils.findRequiredField(Car.class, x.toString());
                    field.setAccessible(true);

                    ReflectionUtils.setField(field, carObject, y);
                });
            carRepository.save(carObject);
            return new ResponseEntity<Car>(carObject, HttpStatus.OK);
        }

        return null;
    }
}
