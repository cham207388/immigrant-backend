package com.immigrant.dream.story.controller;

import com.immigrant.dream.story.entity.Immigrant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface ImmigrantController {

    List<Immigrant> findAll();

    List<Immigrant> findAllByPrefession(@PathVariable String profession);

    Immigrant findById(@PathVariable Long id);

    Immigrant findByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName);

    Immigrant save(@RequestBody Immigrant immigrant);

    @ResponseStatus(HttpStatus.CREATED)
    List<Immigrant> saveAll(@RequestBody List<Immigrant> immigrant);
}
