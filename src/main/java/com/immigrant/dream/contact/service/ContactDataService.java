package com.immigrant.dream.contact.service;

import com.immigrant.dream.contact.entity.ContactData;
import com.immigrant.dream.contact.repository.ContactDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactDataService {

    @Autowired
    private ContactDataRepository contactDataRepository;

    @Autowired
    private MailService mailService;

    public ContactData save(ContactData contactData) {
        mailService.sendEmail(contactData);
        return contactDataRepository.save(contactData);
    }
}
