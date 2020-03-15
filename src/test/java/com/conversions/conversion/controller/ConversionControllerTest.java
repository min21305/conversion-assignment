package com.conversions.conversion.controller;

import com.conversions.conversion.service.ConversionService;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class ConversionControllerTest {

    @InjectMocks
    private ConversionController conversionController;

    @Mock
    private ConversionService conversionService;

    private MockMvc mockMvc;

    private static MappingJackson2HttpMessageConverter buildJacksonConverter() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return new MappingJackson2HttpMessageConverter(builder.build());
    }

    @Before
    public void initializeMocks() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(conversionController)
                .setMessageConverters(buildJacksonConverter())
                .build();
    }

    @Test
    public void ktoc_test() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/conversions/KtoC")
                .param("kelvin", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        verify(conversionService).getKtoC(anyDouble());
        assertNotNull(jsonResponse);
    }

    @Test
    public void ctoK_test() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/conversions/CtoK")
                .param("celsius", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        verify(conversionService).getCtoK(anyDouble());
        assertNotNull(jsonResponse);
    }

    @Test
    public void mtok_test() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/conversions/MtoK")
                .param("miles", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        verify(conversionService).getMtoK(anyDouble());
        assertNotNull(jsonResponse);
    }

    @Test
    public void ktoM_test() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/conversions/KtoM")
                .param("kilometers", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        verify(conversionService).getKtoM(anyDouble());
        assertNotNull(jsonResponse);
    }
}
