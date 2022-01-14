package com.dev.rev.prova.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dev.rev.prova.entities.Brand;
import com.dev.rev.prova.entities.Car;
import com.dev.rev.prova.entities.Model;
import com.dev.rev.prova.enums.CarColor;
import com.dev.rev.prova.enums.CarFuel;
import com.dev.rev.prova.enums.CarTransmission;
import com.dev.rev.prova.enums.CarType;
import com.dev.rev.prova.exceptions.classes.notfound.CarNotFoundException;
import com.dev.rev.prova.repositories.CarRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ContextConfiguration(classes = {CarService.class})
@ExtendWith(SpringExtension.class)
class CarServiceTest {

    @MockBean
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @Test
    void testGetAllCars() {
        when(this.carRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<List<Car>> actualAllCars = this.carService.getAllCars();
        assertEquals("<200 OK OK,[],[]>", actualAllCars.toString());
        assertTrue(actualAllCars.hasBody());
        assertEquals(HttpStatus.OK, actualAllCars.getStatusCode());
        assertTrue(actualAllCars.getHeaders().isEmpty());
        verify(this.carRepository).findAll();
    }

    @Test
    void testGetById() throws CarNotFoundException {
        Brand brand = new Brand();
        brand.setId(123L);
        brand.setName("Name");

        Brand brand1 = new Brand();
        brand1.setId(123L);
        brand1.setName("Name");

        Model model = new Model();
        model.setBrand(brand1);
        model.setId(123L);
        model.setName("Name");

        Car car = new Car();
        car.setAgeCar(1L);
        car.setBrand(brand);
        car.setCarColor(CarColor.AMARELO);
        car.setCarFuel(CarFuel.DIESEL);
        car.setCarTransmission(CarTransmission.AUTOMATICO);
        car.setCarType(CarType.CONVERTIBLE);
        car.setId(123L);
        car.setIpva(true);
        car.setKm(10.0);
        car.setModel(model);
        car.setName("Name");
        car.setPhoto("alice.liddell@example.org");
        car.setPrice(10.0);
        car.setReserved(true);
        Optional<Car> ofResult = Optional.of(car);
        when(this.carRepository.findById((Long) any())).thenReturn(ofResult);
        ResponseEntity<Car> actualById = this.carService.getById(123L);
        assertTrue(actualById.getHeaders().isEmpty());
        assertTrue(actualById.hasBody());
        assertEquals(HttpStatus.OK, actualById.getStatusCode());
        verify(this.carRepository).findById((Long) any());
    }

    @Test
    void testGetByIdThrowError() throws CarNotFoundException {
        when(this.carRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(CarNotFoundException.class, () -> this.carService.getById(123L));
        verify(this.carRepository).findById((Long) any());
    }

    @Test
    void testGetPage() {
        when(this.carRepository.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        ResponseEntity<Page<Car>> actualPage = this.carService.getPage(null);
        assertEquals("<200 OK OK,Page 1 of 1 containing UNKNOWN instances,[]>", actualPage.toString());
        assertTrue(actualPage.getBody().toList().isEmpty());
        assertTrue(actualPage.hasBody());
        assertEquals(HttpStatus.OK, actualPage.getStatusCode());
        assertTrue(actualPage.getHeaders().isEmpty());
        verify(this.carRepository).findAll((org.springframework.data.domain.Pageable) any());
    }

    @Test
    void testSaveCar() {
        Brand brand = new Brand();
        brand.setId(123L);
        brand.setName("Name");

        Brand brand1 = new Brand();
        brand1.setId(123L);
        brand1.setName("Name");

        Model model = new Model();
        model.setBrand(brand1);
        model.setId(123L);
        model.setName("Name");

        Car car = new Car();
        car.setAgeCar(1L);
        car.setBrand(brand);
        car.setCarColor(CarColor.AMARELO);
        car.setCarFuel(CarFuel.DIESEL);
        car.setCarTransmission(CarTransmission.AUTOMATICO);
        car.setCarType(CarType.CONVERTIBLE);
        car.setId(123L);
        car.setIpva(true);
        car.setKm(10.0);
        car.setModel(model);
        car.setName("Name");
        car.setPhoto("alice.liddell@example.org");
        car.setPrice(10.0);
        car.setReserved(true);
        when(this.carRepository.save((Car) any())).thenReturn(car);

        Brand brand2 = new Brand();
        brand2.setId(123L);
        brand2.setName("Name");

        Brand brand3 = new Brand();
        brand3.setId(123L);
        brand3.setName("Name");

        Model model1 = new Model();
        model1.setBrand(brand3);
        model1.setId(123L);
        model1.setName("Name");

        Car car1 = new Car();
        car1.setAgeCar(1L);
        car1.setBrand(brand2);
        car1.setCarColor(CarColor.AMARELO);
        car1.setCarFuel(CarFuel.DIESEL);
        car1.setCarTransmission(CarTransmission.AUTOMATICO);
        car1.setCarType(CarType.CONVERTIBLE);
        car1.setId(123L);
        car1.setIpva(true);
        car1.setKm(10.0);
        car1.setModel(model1);
        car1.setName("Name");
        car1.setPhoto("alice.liddell@example.org");
        car1.setPrice(10.0);
        car1.setReserved(true);
        assertSame(car, this.carService.saveCar(car1));
        verify(this.carRepository).save((Car) any());
    }

    @Test
    void testDeleteCarById() throws CarNotFoundException {
        doNothing().when(this.carRepository).deleteById((Long) any());
        this.carService.deleteCarById(123L);
        verify(this.carRepository).deleteById((Long) any());
    }

    @Test
    void testUpdate() throws CarNotFoundException {
        Brand brand = new Brand();
        brand.setId(123L);
        brand.setName("Name");

        Brand brand1 = new Brand();
        brand1.setId(123L);
        brand1.setName("Name");

        Model model = new Model();
        model.setBrand(brand1);
        model.setId(123L);
        model.setName("Name");

        Car car = new Car();
        car.setAgeCar(1L);
        car.setBrand(brand);
        car.setCarColor(CarColor.AMARELO);
        car.setCarFuel(CarFuel.DIESEL);
        car.setCarTransmission(CarTransmission.AUTOMATICO);
        car.setCarType(CarType.CONVERTIBLE);
        car.setId(123L);
        car.setIpva(true);
        car.setKm(10.0);
        car.setModel(model);
        car.setName("Name");
        car.setPhoto("alice.liddell@example.org");
        car.setPrice(10.0);
        car.setReserved(true);
        Optional<Car> ofResult = Optional.of(car);

        Brand brand2 = new Brand();
        brand2.setId(123L);
        brand2.setName("Name");

        Brand brand3 = new Brand();
        brand3.setId(123L);
        brand3.setName("Name");

        Model model1 = new Model();
        model1.setBrand(brand3);
        model1.setId(123L);
        model1.setName("Name");

        Car car1 = new Car();
        car1.setAgeCar(1L);
        car1.setBrand(brand2);
        car1.setCarColor(CarColor.AMARELO);
        car1.setCarFuel(CarFuel.DIESEL);
        car1.setCarTransmission(CarTransmission.AUTOMATICO);
        car1.setCarType(CarType.CONVERTIBLE);
        car1.setId(123L);
        car1.setIpva(true);
        car1.setKm(10.0);
        car1.setModel(model1);
        car1.setName("Name");
        car1.setPhoto("alice.liddell@example.org");
        car1.setPrice(10.0);
        car1.setReserved(true);
        when(this.carRepository.save((Car) any())).thenReturn(car1);
        when(this.carRepository.findById((Long) any())).thenReturn(ofResult);

        Brand brand4 = new Brand();
        brand4.setId(123L);
        brand4.setName("Name");

        Brand brand5 = new Brand();
        brand5.setId(123L);
        brand5.setName("Name");

        Model model2 = new Model();
        model2.setBrand(brand5);
        model2.setId(123L);
        model2.setName("Name");

        Car car2 = new Car();
        car2.setAgeCar(1L);
        car2.setBrand(brand4);
        car2.setCarColor(CarColor.AMARELO);
        car2.setCarFuel(CarFuel.DIESEL);
        car2.setCarTransmission(CarTransmission.AUTOMATICO);
        car2.setCarType(CarType.CONVERTIBLE);
        car2.setId(123L);
        car2.setIpva(true);
        car2.setKm(10.0);
        car2.setModel(model2);
        car2.setName("Name");
        car2.setPhoto("alice.liddell@example.org");
        car2.setPrice(10.0);
        car2.setReserved(true);
        ResponseEntity<Car> actualUpdateResult = this.carService.update(123L, car2);
        assertEquals(car2, actualUpdateResult.getBody());
        assertTrue(actualUpdateResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.ACCEPTED, actualUpdateResult.getStatusCode());
        verify(this.carRepository).findById((Long) any());
        verify(this.carRepository).save((Car) any());
        assertEquals(123L, car2.getId().longValue());
    }

    @Test
    void testUpdateThrowError() throws CarNotFoundException {
        Brand brand = new Brand();
        brand.setId(123L);
        brand.setName("Name");

        Brand brand1 = new Brand();
        brand1.setId(123L);
        brand1.setName("Name");

        Model model = new Model();
        model.setBrand(brand1);
        model.setId(123L);
        model.setName("Name");

        Car car = new Car();
        car.setAgeCar(1L);
        car.setBrand(brand);
        car.setCarColor(CarColor.AMARELO);
        car.setCarFuel(CarFuel.DIESEL);
        car.setCarTransmission(CarTransmission.AUTOMATICO);
        car.setCarType(CarType.CONVERTIBLE);
        car.setId(123L);
        car.setIpva(true);
        car.setKm(10.0);
        car.setModel(model);
        car.setName("Name");
        car.setPhoto("alice.liddell@example.org");
        car.setPrice(10.0);
        car.setReserved(true);
        when(this.carRepository.save((Car) any())).thenReturn(car);
        when(this.carRepository.findById((Long) any())).thenReturn(Optional.empty());

        Brand brand2 = new Brand();
        brand2.setId(123L);
        brand2.setName("Name");

        Brand brand3 = new Brand();
        brand3.setId(123L);
        brand3.setName("Name");

        Model model1 = new Model();
        model1.setBrand(brand3);
        model1.setId(123L);
        model1.setName("Name");

        Car car1 = new Car();
        car1.setAgeCar(1L);
        car1.setBrand(brand2);
        car1.setCarColor(CarColor.AMARELO);
        car1.setCarFuel(CarFuel.DIESEL);
        car1.setCarTransmission(CarTransmission.AUTOMATICO);
        car1.setCarType(CarType.CONVERTIBLE);
        car1.setId(123L);
        car1.setIpva(true);
        car1.setKm(10.0);
        car1.setModel(model1);
        car1.setName("Name");
        car1.setPhoto("alice.liddell@example.org");
        car1.setPrice(10.0);
        car1.setReserved(true);
        assertThrows(CarNotFoundException.class, () -> this.carService.update(123L, car1));
        verify(this.carRepository).findById((Long) any());
    }

    @Test
    void testPatch() throws CarNotFoundException {
        Brand brand = new Brand();
        brand.setId(123L);
        brand.setName("Name");

        Brand brand1 = new Brand();
        brand1.setId(123L);
        brand1.setName("Name");

        Model model = new Model();
        model.setBrand(brand1);
        model.setId(123L);
        model.setName("Name");

        Car car = new Car();
        car.setAgeCar(1L);
        car.setBrand(brand);
        car.setCarColor(CarColor.AMARELO);
        car.setCarFuel(CarFuel.DIESEL);
        car.setCarTransmission(CarTransmission.AUTOMATICO);
        car.setCarType(CarType.CONVERTIBLE);
        car.setId(123L);
        car.setIpva(true);
        car.setKm(10.0);
        car.setModel(model);
        car.setName("Name");
        car.setPhoto("alice.liddell@example.org");
        car.setPrice(10.0);
        car.setReserved(true);
        Optional<Car> ofResult = Optional.of(car);

        Brand brand2 = new Brand();
        brand2.setId(123L);
        brand2.setName("Name");

        Brand brand3 = new Brand();
        brand3.setId(123L);
        brand3.setName("Name");

        Model model1 = new Model();
        model1.setBrand(brand3);
        model1.setId(123L);
        model1.setName("Name");

        Car car1 = new Car();
        car1.setAgeCar(1L);
        car1.setBrand(brand2);
        car1.setCarColor(CarColor.AMARELO);
        car1.setCarFuel(CarFuel.DIESEL);
        car1.setCarTransmission(CarTransmission.AUTOMATICO);
        car1.setCarType(CarType.CONVERTIBLE);
        car1.setId(123L);
        car1.setIpva(true);
        car1.setKm(10.0);
        car1.setModel(model1);
        car1.setName("Name");
        car1.setPhoto("alice.liddell@example.org");
        car1.setPrice(10.0);
        car1.setReserved(true);
        when(this.carRepository.save((Car) any())).thenReturn(car1);
        when(this.carRepository.findById((Long) any())).thenReturn(ofResult);
        ResponseEntity<Car> actualPatchResult = this.carService.patch(123L, new HashMap<>());
        assertEquals(car1, actualPatchResult.getBody());
        assertTrue(actualPatchResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualPatchResult.getStatusCode());
        verify(this.carRepository).findById((Long) any());
        verify(this.carRepository).save((Car) any());
    }

    @Test
    void testPatchThrowError() throws CarNotFoundException {
        Brand brand = new Brand();
        brand.setId(123L);
        brand.setName("Name");

        Brand brand1 = new Brand();
        brand1.setId(123L);
        brand1.setName("Name");

        Model model = new Model();
        model.setBrand(brand1);
        model.setId(123L);
        model.setName("Name");

        Car car = new Car();
        car.setAgeCar(1L);
        car.setBrand(brand);
        car.setCarColor(CarColor.AMARELO);
        car.setCarFuel(CarFuel.DIESEL);
        car.setCarTransmission(CarTransmission.AUTOMATICO);
        car.setCarType(CarType.CONVERTIBLE);
        car.setId(123L);
        car.setIpva(true);
        car.setKm(10.0);
        car.setModel(model);
        car.setName("Name");
        car.setPhoto("alice.liddell@example.org");
        car.setPrice(10.0);
        car.setReserved(true);
        when(this.carRepository.save((Car) any())).thenReturn(car);
        when(this.carRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(CarNotFoundException.class, () -> this.carService.patch(123L, new HashMap<>()));
        verify(this.carRepository).findById((Long) any());
    }

}