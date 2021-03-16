package com.immigrant.dream.story.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.immigrant.dream.story.entity.Immigrant;
import com.immigrant.dream.story.service.ImmigrantService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ImmigrantControllerImpl.class)
@DisplayName("ImmigrantContext Test")
class ImmigrantControllerImplTest {
    private static final String LOCAL_HOST = "http://localhost:8000/stories";

    private static final String FIRST_NAME = "john";
    private static final String LAST_NAME = "johnson";
    private static final String PROFESSION = "engineer";
    private static final String STORY = "story";
    private static final String HUBBY = "reading";
    private static final String ORIGIN = "the gambia";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ImmigrantService immigrantService;

    @Test
    @DisplayName("Find all")
    void findAll() throws Exception {
        when(immigrantService.findAll()).thenReturn(Collections.singletonList(immigrantId()));
        mockMvc.perform(get(LOCAL_HOST)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Find all by profession")
    void findAllByPrefession() throws Exception {
        when(immigrantService.findAllByProfession(any())).thenReturn(Collections.singletonList(immigrantId()));
        mockMvc.perform(get(LOCAL_HOST + "/profession/engineer")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Find by first and last name")
    void findByFirstNameAndLastName() throws Exception {
        when(immigrantService.findByFirstNameAndLastName(anyString(), anyString())).thenReturn((immigrantId()));
        mockMvc.perform(get(LOCAL_HOST + "/story/firstName/john/lastName/johnson")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("save")
    void save() throws Exception {
        when(immigrantService.save(any())).thenReturn(immigrantId());
        mockMvc.perform(post(LOCAL_HOST)
                .content(objectMapper.writeValueAsString(immigrant()))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }

    private Immigrant immigrant() {
        Immigrant immigrant = new Immigrant();
        immigrant.setFirstName(FIRST_NAME);
        immigrant.setLastName(LAST_NAME);
        immigrant.setProfession(PROFESSION);
        immigrant.setStory(STORY);
        immigrant.setHubby(HUBBY);
        immigrant.setOrigin(ORIGIN);
        return immigrant;
    }

    private Immigrant immigrantId() {
        Immigrant immigrant = immigrant();
        immigrant.setId(1L);
        return immigrant;
    }
}