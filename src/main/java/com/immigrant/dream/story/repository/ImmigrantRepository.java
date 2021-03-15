package com.immigrant.dream.story.repository;

import com.immigrant.dream.story.entity.Immigrant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImmigrantRepository extends CrudRepository<Immigrant, Long> {

    Optional<Immigrant> findByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Immigrant> findAllByProfession(String profession);
}
