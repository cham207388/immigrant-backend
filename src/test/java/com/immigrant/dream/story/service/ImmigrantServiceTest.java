package com.immigrant.dream.story.service;

import com.immigrant.dream.exception.ImmigrantException;
import com.immigrant.dream.story.entity.Immigrant;
import com.immigrant.dream.story.repository.ImmigrantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ImmigrantServiceTest {
    private static final String FIRST_NAME = "john";
    private static final String LAST_NAME = "johnson";
    private static final String PROFESSION = "engineer";
    private static final String STORY = "story";
    private static final String HUBBY = "reading";
    private static final String ORIGIN = "the gambia";

    @InjectMocks
    private ImmigrantService classUnderTest;

    @Mock
    private ImmigrantRepository immigrantRepository;


    @Test
    void findAll() {
        when(immigrantRepository.findAll()).thenReturn(Collections.singletonList(immigrantId()));
        assertNotNull(classUnderTest.findAll());
    }

    @Test
    void findAllByProfession() {
        when(immigrantRepository.findAllByProfession(anyString())).thenReturn(Collections.singletonList(immigrantId()));
        assertNotNull(classUnderTest.findAllByProfession(PROFESSION));
    }

    @Test
    void findAllByProfessionException() {
        when(immigrantRepository.findAllByProfession(anyString())).thenThrow(ImmigrantException.class);
        assertThrows(ImmigrantException.class,
                () -> {
                    classUnderTest.findAllByProfession(PROFESSION);
                });
    }

    @Test
    void findByFirstNameAndLastName() {
        when(immigrantRepository.findByFirstNameAndLastName(anyString(), anyString())).thenReturn(Optional.of(immigrantId()));
        assertNotNull(classUnderTest.findByFirstNameAndLastName(FIRST_NAME, LAST_NAME));
    }

    @Test
    void save() {
        when(immigrantRepository.save(any())).thenReturn(immigrantId());
        assertNotNull(classUnderTest.save(immigrant()));
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