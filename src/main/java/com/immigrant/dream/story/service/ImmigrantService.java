package com.immigrant.dream.story.service;


import com.immigrant.dream.exception.ImmigrantException;
import com.immigrant.dream.story.entity.Immigrant;
import com.immigrant.dream.story.repository.ImmigrantRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        immigrantRepository.findAllByProfession(StringUtils.capitalize(profession)).forEach(immigrants::add);
        if (immigrants.size() == 0) {
            throw new ImmigrantException("No Immigrant matches a profession: " + profession);
        }
        return immigrants;
    }

    public Immigrant findByFirstNameAndLastName(String firstName, String lastName) {
        return immigrantRepository.findByFirstNameAndLastName(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName)).orElseThrow(() ->
                new ImmigrantException("No Immigrant matches " + firstName + " " + lastName)
        );
    }

    public Immigrant save(Immigrant immigrant) {
        return immigrantRepository.save(Immigrant.capitalize(Immigrant.lowerCase(immigrant)));
    }

    public List<Immigrant> saveAll(List<Immigrant> immigrants) {
        immigrants = immigrants.stream().map(immigrant -> Immigrant.capitalize(Immigrant.lowerCase(immigrant))).collect(Collectors.toList());
        List<Immigrant> list = new ArrayList<>();
        immigrantRepository.saveAll(immigrants).forEach(list::add);
        return list;
    }

    public Immigrant findById(Long id) {
        return immigrantRepository.findById(id).orElseThrow(
                () -> new ImmigrantException("No Immigrant matches this criterium")
        );
    }
}
