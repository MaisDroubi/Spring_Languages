package com.assignment.languages.repositories;


import com.assignment.languages.models.language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface languageRepository extends CrudRepository<language, Long> {
    List<language> findAll();




}