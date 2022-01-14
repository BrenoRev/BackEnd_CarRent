package com.dev.rev.prova.Repositories;

import com.dev.rev.prova.Entities.Brand;
import com.dev.rev.prova.Entities.Car;
import com.dev.rev.prova.Entities.Model;
import com.dev.rev.prova.Enums.CarColor;
import com.dev.rev.prova.Enums.CarFuel;
import com.dev.rev.prova.Enums.CarTransmission;
import com.dev.rev.prova.Enums.CarType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepositoryTest;

    @Autowired
    private BrandRepository brandRepositoryTest;

    @Autowired
    private ModelRepository modelRepositoryTest;

    Brand brand;
    Model model;
    Car carro;

    @BeforeEach
    public void instantiate(){
        brand = new Brand(null, "Brand Test");
        saveBrand(brand);

        model = new Model(null , brand, "Model Test");
        saveModel(model);

        carro = new Car(
                1L,
                model,
                brand,
                "Mustang",
                1999L,
                25000.0,
                85000.0,
                true,
                false,
                "photo.com"
                , Enum.valueOf( CarType.class,"SEDAN")
                , Enum.valueOf(CarTransmission.class,"AUTOMATICO")
                , Enum.valueOf( CarColor.class,"AMARELO")
                , Enum.valueOf( CarFuel.class,"GASOLINA"));

        saveCar(carro);

    }

    @AfterEach
    public void dropAll(){
        carRepositoryTest.deleteAll();
        brandRepositoryTest.deleteAll();
        modelRepositoryTest.deleteAll();
    }

    public Brand saveBrand(Brand brand){
       return brandRepositoryTest.save(brand);
    }

    public Model saveModel(Model model){
        return modelRepositoryTest.save(model);
    }

    public Car saveCar(Car car){
        return carRepositoryTest.save(car);
    }

    @Test
    void itShouldSaveACar(){

        // Given

        Car carro = new Car(
                null,
                model,
                brand,
                "TestFiat",
                1875L,
                32000.0,
                35000.0,
                false,
                true,
                "photoTest.com"
                , Enum.valueOf( CarType.class,"VAN")
                , Enum.valueOf(CarTransmission.class,"MANUAL")
                , Enum.valueOf( CarColor.class,"PRETO")
                , Enum.valueOf( CarFuel.class,"DIESEL"));

        // When

            Car carroSalvo =  carRepositoryTest.save(carro);

        //Then

        assertThat(carroSalvo.getId()).isNotNull();
        assertThat(carroSalvo.getName().equals(carro.getName())).isTrue();

    }

    @Test
    void itShouldUpdateACar(){

        // Given

        Car carroNovo = new Car(
                null,
                model,
                brand,
                "Novo Update",
                2001L,
                35000.0,
                99999.0,
                false,
                true,
                "google.com"
                , Enum.valueOf( CarType.class,"HATCHBACK")
                , Enum.valueOf(CarTransmission.class,"MANUAL")
                , Enum.valueOf( CarColor.class,"AZUL")
                , Enum.valueOf( CarFuel.class,"FLEX"));

                Car carroSalvo = carRepositoryTest.save(carroNovo);

        // When
            carroSalvo.setName("Hilux");
            carroSalvo.setCarColor(CarColor.DOURADO);

            Car carroAtualizado = carRepositoryTest.save(carroSalvo);

        // Then

            assertThat(carroSalvo.getId().equals(carroAtualizado.getId())).isTrue();
            assertThat(carroSalvo.getName().equals("Hilux")).isTrue();
            assertThat(carroSalvo.getCarColor().equals(CarColor.DOURADO)).isTrue();

    }

    @Test
    void itShouldDeleteACar(){

        // Given

        Car carroToDelete = new Car(
                null,
                model,
                brand,
                "Novo Update",
                2001L,
                35000.0,
                99999.0,
                false,
                true,
                "google.com"
                , Enum.valueOf( CarType.class,"HATCHBACK")
                , Enum.valueOf(CarTransmission.class,"MANUAL")
                , Enum.valueOf( CarColor.class,"AZUL")
                , Enum.valueOf( CarFuel.class,"FLEX"));

        Car carroSalvo = carRepositoryTest.save(carroToDelete);

        // When

        carRepositoryTest.deleteById(carroSalvo.getId());

        //Then

        assertThat(carRepositoryTest.findById(carroSalvo.getId()).isEmpty()).isTrue();
    }

    @Test
    void itShouldGetListOfCars(){
        // Given

        Car carroToSave = new Car(
                null,
                model,
                brand,
                "Mustang",
                1999L,
                25000.0,
                85000.0,
                true,
                false,
                "photo.com"
                , Enum.valueOf( CarType.class,"SEDAN")
                , Enum.valueOf(CarTransmission.class,"AUTOMATICO")
                , Enum.valueOf( CarColor.class,"AMARELO")
                , Enum.valueOf( CarFuel.class,"GASOLINA"));

        List<Car> carrosToVerify = new ArrayList<>();
        for(int i = 0; i <= 5; i++){
            carRepositoryTest.save(carroToSave);
            carrosToVerify.add(carroToSave);
        }

        // When
            List<Car> carros = carRepositoryTest.findAll();

        // Then
        System.out.println(carros.size());
            assertThat(carros.contains(carroToSave)).isTrue();
            assertThat(carros.containsAll(carrosToVerify)).isTrue();

    }
}
