package com.immigrant.dream.contact.controller;

import com.immigrant.dream.contact.entity.ContactData;
import com.immigrant.dream.contact.service.ContactDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/contact-data")
@CrossOrigin(maxAge = 3600)
public class ContactDataControllerImpl implements ContactDataController {

    @Autowired
    private ContactDataService contactDataService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ContactData save(@RequestBody @Valid ContactData contactData){
        return contactDataService.save(contactData);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ContactData> findAll(){
        return contactDataService.findAll();
    }
}
