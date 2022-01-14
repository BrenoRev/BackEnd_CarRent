package com.dev.rev.prova.Controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EnumsController.class})
@ExtendWith(SpringExtension.class)
class EnumsControllerTest {
    @Autowired
    private EnumsController enumsController;

    @Test
    void testGetCarTypes() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/enums/cartypes");
        MockMvcBuilders.standaloneSetup(this.enumsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[\"Convertible\",\"Coupe\",\"Hatchback\",\"Pickup\",\"Sedan\",\"Suv\",\"Van\"]"));
    }

    @Test
    void testGetCarTypes2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/enums/cartypes", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.enumsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[\"Convertible\",\"Coupe\",\"Hatchback\",\"Pickup\",\"Sedan\",\"Suv\",\"Van\"]"));
    }

    @Test
    void testGetColors() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/enums/colors");
        MockMvcBuilders.standaloneSetup(this.enumsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[\"Amarelo\",\"Azul\",\"Bege\",\"Branco\",\"Cinza\",\"Dourado\",\"Laranja\",\"Marrom\",\"Prata\",\"Preto\",\"Roxo\",\"Verde"
                                        + "\",\"Vermelho\",\"Outros\"]"));
    }

    @Test
    void testGetColors2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/enums/colors");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.enumsController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[\"Amarelo\",\"Azul\",\"Bege\",\"Branco\",\"Cinza\",\"Dourado\",\"Laranja\",\"Marrom\",\"Prata\",\"Preto\",\"Roxo\",\"Verde"
                                        + "\",\"Vermelho\",\"Outros\"]"));
    }

    @Test
    void testGetFuels() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/enums/fuels");
        MockMvcBuilders.standaloneSetup(this.enumsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[\"Diesel\",\"Flex\",\"Gasolina\",\"HÃ­brido\"]"));
    }

    @Test
    void testGetFuels2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/enums/fuels");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.enumsController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[\"Diesel\",\"Flex\",\"Gasolina\",\"HÃ­brido\"]"));
    }

    @Test
    void testGetTransmissions() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/enums/transmissions");
        MockMvcBuilders.standaloneSetup(this.enumsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[\"Automatico\",\"Manual\"]"));
    }

    @Test
    void testGetTransmissions2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/enums/transmissions");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.enumsController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[\"Automatico\",\"Manual\"]"));
    }
}

