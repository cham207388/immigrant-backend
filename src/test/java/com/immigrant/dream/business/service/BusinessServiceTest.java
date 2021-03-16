package com.immigrant.dream.business.service;

import com.immigrant.dream.business.entity.Business;
import com.immigrant.dream.business.repository.BusinessRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class BusinessServiceTest {

    @InjectMocks
    private BusinessService classUnderTest;

    @Mock
    private BusinessRepository businessRepository;

    @Test
    void findById() {
        when(businessRepository.findById(anyLong())).thenReturn(Optional.of(business()));
        assertNotNull(classUnderTest.findById(1L));
    }

    @Test
    void findByBusinessName() {
        when(businessRepository.findByBusinessName(anyString())).thenReturn(Optional.of(business()));
        assertNotNull(classUnderTest.findByBusinessName("name"));
    }

    @Test
    void findAll() {
        when(businessRepository.findAll()).thenReturn(Collections.singletonList(business()));
        assertNotNull(classUnderTest.findAll());
    }

    @Test
    void findAllByBusinessType() {
        when(businessRepository.findAllByBusinessType(anyString())).thenReturn(Collections.singletonList(business()));
        assertNotNull(classUnderTest.findAllByBusinessType("type"));
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