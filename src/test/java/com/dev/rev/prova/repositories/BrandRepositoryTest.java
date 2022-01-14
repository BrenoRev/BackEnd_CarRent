package com.dev.rev.prova.repositories;

import com.dev.rev.prova.entities.Brand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BrandRepositoryTest {

    @Autowired
    BrandRepository brandRepositoryTest;

    private Brand brand;
    private final String NAME = "TEST_BRAND";

    @BeforeEach
    public void instantiate(){
        brand = new Brand();
        brand.setName(NAME);

        brandRepositoryTest.save(brand);
    }

    @AfterEach
    public void dropAll(){
        brandRepositoryTest.deleteAll();
    }

    @Test
    void ItShouldGetBrandByName() {

        // Given

        Brand brandFound = brandRepositoryTest.findByName(NAME);

        // Then

        assertThat(brandFound.getId().equals(brand.getId())).isTrue();
        assertThat(brand.equals(brandFound)).isTrue();

    }
}