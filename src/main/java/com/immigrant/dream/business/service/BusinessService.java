package com.immigrant.dream.business.service;

import com.immigrant.dream.business.entity.Business;
import com.immigrant.dream.business.repository.BusinessRepository;
import com.immigrant.dream.exception.ImmigrantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public Business findById(Long id){
        return businessRepository.findById(id).
                orElseThrow(()-> new ImmigrantException("System unavailable! Retry"));
    }

    public Business findByBusinessName(String businessName){
        return businessRepository.findByBusinessName(businessName).
                orElseThrow(()-> new ImmigrantException("Business Name: "+businessName+" unavailable!"));
    }

    public List<Business> findAll(){
        List<Business> businesses = new ArrayList<>();
        businessRepository.findAll().forEach(businesses::add);
        if (businesses.size() == 0){
            throw new ImmigrantException("Unavailable!");
        }
        return businesses;
    }

    public List<Business> findAllByBusinessType(String businessType){
        List<Business> businesses = new ArrayList<>();
        businessRepository.findAllByBusinessType(businessType).forEach(businesses::add);
        if (businesses.size() == 0){
            throw new ImmigrantException("Unavailable!");
        }
        return businesses;
    }
}
