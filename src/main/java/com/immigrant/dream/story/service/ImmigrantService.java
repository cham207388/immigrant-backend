package com.immigrant.dream.story.service;


import com.immigrant.dream.exception.ImmigrantException;
import com.immigrant.dream.story.entity.Immigrant;
import com.immigrant.dream.story.repository.ImmigrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImmigrantService {

    @Autowired
    private ImmigrantRepository immigrantRepository;

    public List<Immigrant> findAll() {
        List<Immigrant> immigrants = new ArrayList<>();
        immigrantRepository.findAll().forEach(immigrants::add);
        return immigrants;
    }

    public List<Immigrant> findAllByProfession(String profession) {
        List<Immigrant> immigrants = new ArrayList<>();
        immigrantRepository.findAllByProfession(profession.toLowerCase()).forEach(immigrants::add);
        if (immigrants.size() == 0){
            throw new ImmigrantException("No Immigrant matches a profession: " + profession);
        }
        return immigrants;
    }

    public Immigrant findByFirstNameAndLastName(String firstName, String lastName) {
        return immigrantRepository.findByFirstNameAndLastName(firstName.toLowerCase(), lastName.toLowerCase()).orElseThrow(() ->
                new ImmigrantException("No Immigrant matches " + firstName + " " + lastName)
        );
    }

    public Immigrant save(Immigrant immigrant){
        return immigrantRepository.save(Immigrant.toLowerCase(immigrant));
    }
}
