package com.immigrant.dream.business.controller;


import com.immigrant.dream.business.entity.Business;
import com.immigrant.dream.business.service.BusinessService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Business API")
@RestController
@RequestMapping(path = "/businesses")
public class BusinessControllerImpl implements BusinessController {

    @Autowired
    private BusinessService businessService;

    @Override
    @GetMapping(path = "/business/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Business findById(@PathVariable Long id){
        return businessService.findById(id);
    }

    @Override
    @GetMapping(path = "/business/businessName/{businessName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Business findByBusinessName(@PathVariable String businessName){
        return businessService.findByBusinessName(businessName);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Business> findAll(){
        return businessService.findAll();
    }

    @Override
    @GetMapping(path = "/businessType/{businessType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Business> findAllByBusinessType(@PathVariable String businessType){
        return businessService.findAllByBusinessType(businessType);
    }
}
