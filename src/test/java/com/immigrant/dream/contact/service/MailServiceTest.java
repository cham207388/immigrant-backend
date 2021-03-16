package com.immigrant.dream.contact.service;

import com.immigrant.dream.config.MailConfiguration;
import com.immigrant.dream.contact.entity.ContactData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MailServiceTest {
    @InjectMocks
    private MailService classUnderTeest;

    @Mock
    private JavaMailSender javaMailSender;

    @Mock
    private MailConfiguration mailConfiguration;

    @Test
    void sendEmail() {
        when(mailConfiguration.getFrom()).thenReturn("email@mail.com");
        when(mailConfiguration.getReceiverOne()).thenReturn("email@mail.com");
        doNothing().when(javaMailSender).send((MimeMessage) any());
        classUnderTeest.sendEmail(contactData());
        verify(javaMailSender, atMost(1)).send((MimeMessage) any());
    }

    @Test
    void sendEmailFail() {
        when(mailConfiguration.getFrom()).thenReturn("email@mail.com");
        when(mailConfiguration.getReceiverOne()).thenReturn("email@mail.com");
        doNothing().when(javaMailSender).send((MimeMessage) any());
        classUnderTeest.sendEmail(null);
        verify(javaMailSender, atMost(1)).send((MimeMessage) any());
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