package com.dev.rev.prova.repositories;

import com.dev.rev.prova.entities.Brand;
import com.dev.rev.prova.entities.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ModelRepositoryTest {

    @Autowired
    private ModelRepository modelRepositoryTest;

    @Autowired
    private BrandRepository brandRepositoryTest;

    private Brand brand;
    private Model model1;
    private Model model2;

    private String BRAND_TO_FIND = "TEST_BRAND_MODELS";

    @BeforeEach
    void instantiation(){

        brand = new Brand();
        brand.setName(BRAND_TO_FIND);

        model1 = new Model();
        model1.setBrand(brand);
        model1.setName("MODELO_1");

        model2 = new Model();
        model2.setBrand(brand);
        model2.setName("MODELO_2");

        brandRepositoryTest.save(brand);
        modelRepositoryTest.save(model1);
        modelRepositoryTest.save(model2);

    }

    @AfterEach
    public void dropAll(){
        modelRepositoryTest.deleteAll();
    }

    @Test
    void itShouldGetAllBrandByName() {

        // When

        List<Model> modelosFound = modelRepositoryTest.getAllByBrand(BRAND_TO_FIND);

        // Then
        assertThat(modelosFound.containsAll(Arrays.asList(model1, model2))).isTrue();
    }
}