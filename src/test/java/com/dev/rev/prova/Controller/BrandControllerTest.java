package com.dev.rev.prova.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.dev.rev.prova.Entities.Brand;
import com.dev.rev.prova.Unit.Services.BrandService;
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

@ContextConfiguration(classes = {BrandController.class})
@ExtendWith(SpringExtension.class)
class BrandControllerTest {
    @Autowired
    private BrandController brandController;

    @MockBean
    private BrandService brandService;

    @Test
    void testGetAllBrands() throws Exception {
        when(this.brandService.getAllBrands()).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/brand/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.brandController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testSaveBrand() throws Exception {
        when(this.brandService.saveBrand((Brand) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        Brand brand = new Brand();
        brand.setId(123L);
        brand.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(brand);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/brand/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.brandController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }
}

