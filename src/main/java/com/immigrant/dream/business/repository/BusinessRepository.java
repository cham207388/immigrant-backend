package com.immigrant.dream.business.repository;

import com.immigrant.dream.business.entity.Business;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Long> {

    Optional<Business> findByBusinessName(String businessName);

    Iterable<Business> findAllByBusinessType(String businessType);
}
