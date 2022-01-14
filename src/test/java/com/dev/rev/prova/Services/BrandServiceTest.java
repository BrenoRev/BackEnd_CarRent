package com.dev.rev.prova.Services;

import com.dev.rev.prova.Entities.Brand;
import com.dev.rev.prova.Repositories.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    private BrandService brandService;

    @BeforeEach
    void setUp() {
        brandService = new BrandService(brandRepository);
    }

    @Test
    void canGetAllBrands() {

        // When
        brandService.getAllBrands();
        // Then
        verify(brandRepository).findAll();
    }

    @Test
    void saveBrand() {

        // Given

        Brand brand = new Brand(null, "BRAND_TEST");

        // When

        brandService.saveBrand(brand);

        // Then

        ArgumentCaptor<Brand> carArgumentCaptor =
                ArgumentCaptor.forClass(Brand.class);

        verify(brandRepository).save(carArgumentCaptor.capture());

        Brand capturedBrand = carArgumentCaptor.getValue();

        assertThat(capturedBrand).isEqualTo(brand);
    }
}