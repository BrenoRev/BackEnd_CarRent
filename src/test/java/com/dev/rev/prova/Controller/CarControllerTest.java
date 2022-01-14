package com.dev.rev.prova.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.dev.rev.prova.Entities.Brand;
import com.dev.rev.prova.Entities.Car;
import com.dev.rev.prova.Entities.Model;
import com.dev.rev.prova.Enums.CarColor;
import com.dev.rev.prova.Enums.CarFuel;
import com.dev.rev.prova.Enums.CarTransmission;
import com.dev.rev.prova.Enums.CarType;
import com.dev.rev.prova.Exceptions.classes.NotFound.CarNotFoundException;
import com.dev.rev.prova.Services.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CarController.class})
@ExtendWith(SpringExtension.class)
class CarControllerTest {
    @Autowired
    private CarController carController;

    @MockBean
    private CarService carService;

    @Test
    void testGetById() throws Exception {
        when(this.carService.getById((Long) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/car/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testGetById2() throws Exception {
        when(this.carService.getById((Long) any())).thenThrow(new CarNotFoundException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/car/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testGetAllCars() throws Exception {
        when(this.carService.getAllCars()).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/car/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testSaveCar() throws Exception {
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
        when(this.carService.saveCar((Car) any())).thenReturn(car);

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
        String content = (new ObjectMapper()).writeValueAsString(car1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/car/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"model\":{\"id\":123,\"name\":\"Name\"},\"brand\":{\"id\":123,\"name\":\"Name\"},\"name\":\"Name\",\"ageCar\":1"
                                        + ",\"km\":10.0,\"price\":10.0,\"ipva\":true,\"reserved\":true,\"photo\":\"alice.liddell@example.org\",\"carType\":"
                                        + "\"Convertible\",\"carTransmission\":\"Automatico\",\"carColor\":\"Amarelo\",\"carFuel\":\"Diesel\"}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/v1/car/id_created"));
    }

    @Test
    void testDeleteCarById() throws Exception {
        doNothing().when(this.carService).deleteCarById((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/car/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteCarById2() throws Exception {
        doThrow(new CarNotFoundException("An error occurred")).when(this.carService).deleteCarById((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/car/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testGetCarsByPage() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/car/pagination");
        getResult.accept("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("pageable", String.valueOf((Object) null));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(406));
    }

    @Test
    void testPatchCar() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/api/v1/car/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
    }

    @Test
    void testUpdateCar() throws Exception {
        when(this.carService.update((Long) any(), (Car) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

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
        String content = (new ObjectMapper()).writeValueAsString(car);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/car/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testUpdateCar2() throws Exception {
        when(this.carService.update((Long) any(), (Car) any())).thenThrow(new CarNotFoundException("An error occurred"));

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
        String content = (new ObjectMapper()).writeValueAsString(car);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/car/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.carController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

