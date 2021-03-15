package com.immigrant.dream.contact.service;

import com.immigrant.dream.contact.entity.ContactData;
import com.immigrant.dream.contact.repository.ContactDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactDataService {

    @Autowired
    private ContactDataRepository contactDataRepository;

    @Autowired
    private MailService mailService;

    public ContactData mailAndSave(ContactData contactData) {
        mailService.sendEmail(contactData);
        return contactDataRepository.save(contactData);
    }

    public ContactData save(ContactData contactData) {
        return contactDataRepository.save(contactData);
    }

    public List<ContactData> findAll() {
        List<ContactData> contactData = new ArrayList<>();
        contactDataRepository.findAll().forEach(contactData::add);
        return contactData;
    }
}
