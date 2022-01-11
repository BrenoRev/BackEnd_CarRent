package com.dev.rev.prova.Controller;

import com.dev.rev.prova.Enums.CarColor;
import com.dev.rev.prova.Enums.CarFuel;
import com.dev.rev.prova.Enums.CarTransmission;
import com.dev.rev.prova.Enums.CarType;
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
    public ResponseEntity<?> getColors(){
        CarColor[] carColor = CarColor.values();
        return new ResponseEntity<>(carColor, HttpStatus.OK);
    }

    @GetMapping("/fuels")
    public ResponseEntity<?> getFuels(){
        CarFuel[] carFuel = CarFuel.values();
        return new ResponseEntity<>(carFuel, HttpStatus.OK);
    }

    @GetMapping("/transmissions")
    public ResponseEntity<?> getTransmissions(){
        CarTransmission[] carTransmission = CarTransmission.values();
        return new ResponseEntity<>(carTransmission, HttpStatus.OK);
    }

    @GetMapping("/cartypes")
    public ResponseEntity<?> getCarTypes(){
        CarType[] carType = CarType.values();
        return new ResponseEntity<>(carType, HttpStatus.OK);
    }
}
