package com.immigrant.dream.story.controller;

import com.immigrant.dream.story.entity.Immigrant;
import com.immigrant.dream.story.service.ImmigrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stories")
public class ImmigrantController {

    @Autowired
    private ImmigrantService immigrantService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Immigrant> findAll(){
        return immigrantService.findAll();
    }

    @GetMapping(path = "/profession/{profession}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Immigrant> findAllByPrefession(@PathVariable String profession){
        return immigrantService.findAllByProfession(profession);
    }

    @GetMapping(path = "/story/firstName/{firstName}/lastName/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Immigrant findAByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return immigrantService.findByFirstNameAndLastName(firstName, lastName);
    }
}
