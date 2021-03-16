package com.immigrant.dream.contact.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.immigrant.dream.contact.entity.ContactData;
import com.immigrant.dream.contact.service.ContactDataService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ContactDataControllerImpl.class)
@DisplayName("Contact Data Controller Test-> Context")
class ContactDataControllerImplTest {
    private static final String LOCAL_HOST = "http://localhost:8000/contact-data";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactDataService contactDataService;

    @Test
    void save() throws Exception {
        Mockito.when(contactDataService.save(any())).thenReturn(contactData());
        mockMvc.perform(post(LOCAL_HOST)
                .content(objectMapper.writeValueAsString(contactData()))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }

    @Test
    void findAll() throws Exception {
        Mockito.when(contactDataService.findAll()).thenReturn(Collections.singletonList(contactData()));
        mockMvc.perform(get(LOCAL_HOST)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    private ContactData contactData() {
        ContactData contactData = new ContactData();
        contactData.setEmail("cham@email.cm");
        contactData.setFirstName("Alhagie Bai");
        contactData.setLastName("Cham");
        contactData.setMessage("Unit test");

        return contactData;
    }
}