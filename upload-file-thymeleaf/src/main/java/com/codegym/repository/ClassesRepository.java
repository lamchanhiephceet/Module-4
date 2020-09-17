package com.codegym.c0320h1.repository;

import com.codegym.c0320h1.model.Classess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends CrudRepository<Classess, Long> {
    Classess findByName(String name);
}
