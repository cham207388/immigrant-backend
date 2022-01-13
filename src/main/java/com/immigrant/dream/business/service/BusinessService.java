package com.immigrant.dream.business.service;

import com.immigrant.dream.business.entity.Business;
import com.immigrant.dream.business.repository.BusinessRepository;
import com.immigrant.dream.exception.ImmigrantException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public Business findById(Long id) {
        return businessRepository.findById(id).
                orElseThrow(() -> new ImmigrantException("System unavailable! Retry"));
    }

    public Business findByBusinessName(String businessName) {
        return businessRepository.findByBusinessName(StringUtils.capitalize(businessName)).
                orElseThrow(() -> new ImmigrantException("Business Name: " + businessName + " unavailable!"));
    }

    public List<Business> findAll() {
        List<Business> businesses = new ArrayList<>();
        businessRepository.findAll().forEach(businesses::add);
        if (businesses.size() == 0) {
            return new ArrayList<>();
        }
        return businesses;
    }

    public List<Business> findAllByBusinessType(String businessType) {
        List<Business> businesses = new ArrayList<>();
        businessRepository.findAllByBusinessType(StringUtils.capitalize(businessType)).forEach(businesses::add);
        if (businesses.size() == 0) {
            throw new ImmigrantException("Unavailable!");
        }
        return businesses;
    }

    public List<Business> saveAll(List<Business> list) {
        List<Business> businesses = new ArrayList<>();
        list = list.stream().map(business -> Business.capitalize(Business.lowercase(business))).collect(Collectors.toList());
        businessRepository.saveAll(list).forEach(businesses::add);
        if (businesses.size() == 0) {
            throw new ImmigrantException("Unavailable!");
        }
        return businesses;
    }

    public Business save(Business business) {
        return businessRepository.save(Business.capitalize(Business.lowercase(business)));
    }
}
