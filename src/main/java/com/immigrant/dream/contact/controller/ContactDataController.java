package com.immigrant.dream.contact.controller;

import com.immigrant.dream.contact.entity.ContactData;
import com.immigrant.dream.contact.service.ContactDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/contact-data")
public class ContactDataController {

    @Autowired
    private ContactDataService contactDataService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContactData save(@RequestBody @Valid ContactData contactData){

        return contactDataService.save(contactData);
    }
}
