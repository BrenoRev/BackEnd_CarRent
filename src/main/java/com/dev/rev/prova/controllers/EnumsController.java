package com.dev.rev.prova.controllers;

import com.dev.rev.prova.enums.CarColor;
import com.dev.rev.prova.enums.CarFuel;
import com.dev.rev.prova.enums.CarTransmission;
import com.dev.rev.prova.enums.CarType;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Enums's API")
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/enums")
@RestController
public class EnumsController {

    @GetMapping("/colors")
    public ResponseEntity<CarColor[]> getColors(){
        CarColor[] carColor = CarColor.values();
        return new ResponseEntity<>(carColor, HttpStatus.OK);
    }

    @GetMapping("/fuels")
    public ResponseEntity<CarFuel[]> getFuels(){
        CarFuel[] carFuel = CarFuel.values();
        return new ResponseEntity<>(carFuel, HttpStatus.OK);
    }

    @GetMapping("/transmissions")
    public ResponseEntity<CarTransmission[]> getTransmissions(){
        CarTransmission[] carTransmission = CarTransmission.values();
        return new ResponseEntity<>(carTransmission, HttpStatus.OK);
    }

    @GetMapping("/cartypes")
    public ResponseEntity<CarType[]> getCarTypes(){
        CarType[] carType = CarType.values();
        return new ResponseEntity<>(carType, HttpStatus.OK);
    }
}
