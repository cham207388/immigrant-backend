package com.immigrant.dream.business.controller;

import com.immigrant.dream.business.entity.Business;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BusinessController {

    Business findById(@PathVariable Long id);


    Business findByBusinessName(@PathVariable String businessName);


    List<Business> findAll();


    List<Business> findAllByBusinessType(@PathVariable String businessType);


    Business save(@RequestBody Business business);


    List<Business> saveAll(@RequestBody List<Business> business);
}
