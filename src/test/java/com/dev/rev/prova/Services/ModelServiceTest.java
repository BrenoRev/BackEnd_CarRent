package com.dev.rev.prova.Services;

import com.dev.rev.prova.Entities.Brand;
import com.dev.rev.prova.Entities.Model;
import com.dev.rev.prova.Repositories.BrandRepository;
import com.dev.rev.prova.Repositories.ModelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ModelServiceTest {

    @Mock
    private ModelRepository modelRepository;

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private ModelService modelService;

    @Test
    void getByBrand() {
    }

    @Test
    void getAllModels() {

        // When
        modelService.getAllModels();

        // Then
        verify(modelRepository).findAll();

    }

    @Test
    void saveModels() {

        // Given
        List<Model> models = new ArrayList<>();

        Model modelAdd1 = new Model(1L, null, "MODEL_TESTS1");
        Model modelAdd2 = new Model(2L, null, "MODEL_TESTS2");

        models.add(modelAdd1);
        models.add(modelAdd2);

        // When

        List<Model> modelosSalvos = modelService.saveModels(models, "BRAND_TEST").getBody();

        // Then

        assertThat(models.containsAll(modelosSalvos)).isTrue();

    }
}