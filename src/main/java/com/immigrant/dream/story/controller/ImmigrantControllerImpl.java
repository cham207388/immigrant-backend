package com.immigrant.dream.story.controller;

import com.immigrant.dream.story.entity.Immigrant;
import com.immigrant.dream.story.service.ImmigrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stories")
@CrossOrigin(origins = { "http://localhost:3000" })
public class ImmigrantControllerImpl implements ImmigrantController {

    @Autowired
    private ImmigrantService immigrantService;

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Immigrant> findAll(){
        return immigrantService.findAll();
    }

    @Override
    @GetMapping(path = "/profession/{profession}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Immigrant> findAllByPrefession(@PathVariable String profession){
        return immigrantService.findAllByProfession(profession);
    }

    @Override
    @GetMapping(path = "/story/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Immigrant findById(@PathVariable Long id){

        return immigrantService.findById(id);
    }

    @Override
    @GetMapping(path = "/story/firstName/{firstName}/lastName/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Immigrant findByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return Immigrant.capitalize(immigrantService.findByFirstNameAndLastName(firstName, lastName));
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Immigrant save(@RequestBody Immigrant immigrant){
        return immigrantService.save(immigrant);
    }

    @Override
    @PostMapping(path = "/all",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public List<Immigrant> saveAll(List<Immigrant> immigrants) {
        return immigrantService.saveAll(immigrants);
    }
}
