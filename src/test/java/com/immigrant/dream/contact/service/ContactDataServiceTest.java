package com.immigrant.dream.contact.service;

import com.immigrant.dream.contact.entity.ContactData;
import com.immigrant.dream.contact.repository.ContactDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ContactDataServiceTest {

    @InjectMocks
    private ContactDataService contactDataService;

    @Mock
    private ContactDataRepository contactDataRepository;

    @Mock
    private MailService mailService;

    @Test
    void mailAndSave() {
        when(contactDataRepository.save(any())).thenReturn(contactData());
        doNothing().when(mailService).sendEmail(any());
        assertNotNull(contactDataService.save(contactData()));
    }

    @Test
    void save() {
        when(contactDataRepository.save(any())).thenReturn(contactData());
        assertNotNull(contactDataService.save(contactData()));
    }

    @Test
    void findAll() {
        when(contactDataRepository.findAll()).thenReturn(Collections.singletonList(contactData()));
        assertNotNull(contactDataService.findAll());
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