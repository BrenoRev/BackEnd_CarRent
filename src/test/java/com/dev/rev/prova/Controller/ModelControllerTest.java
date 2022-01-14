package com.dev.rev.prova.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.dev.rev.prova.Entities.Model;
import com.dev.rev.prova.Exceptions.classes.NotFound.ModelNotFoundException;
import com.dev.rev.prova.Unit.Services.ModelService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

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

@ContextConfiguration(classes = {ModelController.class})
@ExtendWith(SpringExtension.class)
class ModelControllerTest {
    @Autowired
    private ModelController modelController;

    @MockBean
    private ModelService modelService;

    @Test
    void testGetAllModels() throws Exception {
        when(this.modelService.getAllModels()).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/model/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.modelController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testSaveModels() throws Exception {
        when(this.modelService.saveModels((List<Model>) any(), (String) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/api/v1/model/{brand}", "Brand")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ArrayList<>()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.modelController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testGetModelByBrand() throws Exception {
        when(this.modelService.getByBrand((String) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/model/{brand}", "Brand");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.modelController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testGetModelByBrand2() throws Exception {
        when(this.modelService.getByBrand((String) any())).thenThrow(new ModelNotFoundException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/model/{brand}", "Brand");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.modelController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testGetModelByBrand3() throws Exception {
        when(this.modelService.getAllModels()).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        when(this.modelService.getByBrand((String) any())).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/model/{brand}", "", "Uri Vars");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.modelController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }
}

