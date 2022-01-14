package com.dev.rev.prova.Services;

import com.dev.rev.prova.Entities.Brand;
import com.dev.rev.prova.Entities.Car;
import com.dev.rev.prova.Entities.Model;
import com.dev.rev.prova.Enums.CarColor;
import com.dev.rev.prova.Enums.CarFuel;
import com.dev.rev.prova.Enums.CarTransmission;
import com.dev.rev.prova.Enums.CarType;
import com.dev.rev.prova.Exceptions.classes.NotFound.CarNotFoundException;
import com.dev.rev.prova.Repositories.BrandRepository;
import com.dev.rev.prova.Repositories.CarRepository;
import com.dev.rev.prova.Repositories.ModelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;


import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    private CarService carServiceTest;


    @Mock private BrandRepository brandRepositoryMock;

    @Mock private ModelRepository modelRepositoryMock;

    private Brand brand;
    private Model model;

    @BeforeEach
    void setUp() {
        carServiceTest = new CarService(carRepository);

        brand = new Brand();
        brand.setName("BRAND_MOCK");

        model = new Model();
        model.setBrand(brand);
        model.setName("MODELO_MOCK");

        brandRepositoryMock.save(brand);
        modelRepositoryMock.save(model);

    }

    @Test
    void canGetAllCars() {

        // when
        carServiceTest.getAllCars();
        // then
        verify(carRepository).findAll();

    }

    @Test
    void canGetCarById() throws CarNotFoundException {

        // Given

        Car carro = new Car(
                1L,
                model,
                brand,
                "CAR_TEST",
                1999L,
                25000.0,
                85000.0,
                true,
                false,
                "TEST_PHOTO.com"
                , Enum.valueOf( CarType.class,"SEDAN")
                , Enum.valueOf(CarTransmission.class,"AUTOMATICO")
                , Enum.valueOf( CarColor.class,"AMARELO")
                , Enum.valueOf( CarFuel.class,"GASOLINA"));

        when(carRepository.findById(carro.getId())).thenReturn(Optional.of(carro));

        Car expected = carServiceTest.getById(carro.getId()).getBody();

        assertThat(expected).isSameAs(carro);
        verify(carRepository).findById(carro.getId());

    }

    @Test
    void canGetCarPageable() {

        // Given

        PageRequest pageable = PageRequest.of(1,1, Sort.by("id").ascending());

        // When

        carServiceTest.getPage(pageable);

        // then

        verify(carRepository).findAll(pageable);

    }

    @Test
    void canSaveCar() {

        // Given

       Car carro = new Car(
                1L,
                model,
                brand,
                "CAR_TEST",
                1999L,
                25000.0,
                85000.0,
                true,
                false,
                "TEST_PHOTO.com"
                , Enum.valueOf( CarType.class,"SEDAN")
                , Enum.valueOf(CarTransmission.class,"AUTOMATICO")
                , Enum.valueOf( CarColor.class,"AMARELO")
                , Enum.valueOf( CarFuel.class,"GASOLINA"));

       // When

        carServiceTest.saveCar(carro);

        // Then

        ArgumentCaptor<Car> carArgumentCaptor =
                ArgumentCaptor.forClass(Car.class);

        verify(carRepository).save(carArgumentCaptor.capture());

        Car capturedCar = carArgumentCaptor.getValue();

        assertThat(capturedCar).isEqualTo(carro);
    }

    @Test
    void canDeleteACarById() throws CarNotFoundException {

        // When

        carServiceTest.deleteCarById(2L);

        // Then

        verify(carRepository).deleteById(2L);
    }

    @Test
    public void shouldTrownErrorWhenCarNotExists() throws CarNotFoundException {
        Assertions.assertThrows(CarNotFoundException.class, () -> {
            Car carro = new Car();
            carro.setId(9999L);

            given(carRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
            carServiceTest.getById(carro.getId());
        });

    }

    @Test
    void canUpdateACar() throws CarNotFoundException {

        // Given

        Car carroToBeUpdated = new Car(
                1L,
                model,
                brand,
                "CAR_TO_UPDATE",
                2005L,
                25455.0,
                23000.0,
                true,
                false,
                "TEST_PHOTO.com"
                , Enum.valueOf( CarType.class,"SEDAN")
                , Enum.valueOf(CarTransmission.class,"AUTOMATICO")
                , Enum.valueOf( CarColor.class,"PRETO")
                , Enum.valueOf( CarFuel.class,"GASOLINA"));

        Car carroToUpdate = new Car(
                2L,
                model,
                brand,
                "CAR",
                1999L,
                25000.0,
                85000.0,
                true,
                false,
                "TEST_PHOTO.com"
                , Enum.valueOf( CarType.class,"SEDAN")
                , Enum.valueOf(CarTransmission.class,"AUTOMATICO")
                , Enum.valueOf( CarColor.class,"AMARELO")
                , Enum.valueOf( CarFuel.class,"GASOLINA"));


        given(carRepository.findById(carroToBeUpdated.getId())).willReturn(Optional.of(carroToBeUpdated));

        carServiceTest.update(carroToBeUpdated.getId(), carroToUpdate);

        ArgumentCaptor<Car> carArgumentCaptor =
                ArgumentCaptor.forClass(Car.class);

        verify(carRepository).save(carArgumentCaptor.capture());

        Car capturedCar = carArgumentCaptor.getValue();

        assertThat(capturedCar).isEqualTo(carroToUpdate);

        verify(carRepository).findById(carroToUpdate.getId());



    }

}