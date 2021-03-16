package com.immigrant.dream.business.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.immigrant.dream.business.entity.Business;
import com.immigrant.dream.business.service.BusinessService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = BusinessControllerImpl.class)
@DisplayName("Business Context Test")
class BusinessControllerImplTest {
    private static final String LOCAL_HOST = "http://localhost:8000/businesses";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusinessService businessService;

    @Test
    void findById() throws Exception {
        when(businessService.findById(anyLong())).thenReturn(business());
        mockMvc.perform(get(LOCAL_HOST + "/business/id/1")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void findByBusinessName() throws Exception {
        when(businessService.findByBusinessName(anyString())).thenReturn(business());
        mockMvc.perform(get(LOCAL_HOST + "/business/businessName/name")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void findAll() throws Exception {
        when(businessService.findAll()).thenReturn(Collections.singletonList(business()));
        mockMvc.perform(get(LOCAL_HOST)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void findAllByBusinessType() throws Exception {
        when(businessService.findAll()).thenReturn(Collections.singletonList(business()));
        mockMvc.perform(get(LOCAL_HOST + "/businessType/type")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void saveAll() throws Exception {
        when(businessService.saveAll(anyList())).thenReturn(Collections.singletonList(business()));
        mockMvc.perform(post(LOCAL_HOST+ "/all")
                .content(objectMapper.writeValueAsString(Collections.singletonList(business())))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }

    @Test
    void save() throws Exception {
        when(businessService.save(any())).thenReturn(business());
        mockMvc.perform(post(LOCAL_HOST )
                .content(objectMapper.writeValueAsString((business())))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }

    private Business business() {
        Business business = new Business();
        business.setBusinessName("name");
        business.setBusinessDescription("description");
        business.setBusinessLocation("location");
        business.setBusinessProducts("product prod");
        business.setBusinessSite("name.com");
        business.setBusinessType("type");
        return business;
    }
}