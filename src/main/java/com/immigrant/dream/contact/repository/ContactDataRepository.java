package com.immigrant.dream.contact.repository;

import com.immigrant.dream.contact.entity.ContactData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDataRepository extends CrudRepository<ContactData, Long> {

}
