package com.immigrant.dream.contact.controller;

import com.immigrant.dream.contact.entity.ContactData;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface ContactDataController {

    ContactData save(@RequestBody @Valid ContactData contactData);


    List<ContactData> findAll();
}
