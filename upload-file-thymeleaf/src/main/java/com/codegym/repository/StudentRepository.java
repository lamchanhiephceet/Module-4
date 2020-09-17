package com.codegym.c0320h1.repository;

import com.codegym.c0320h1.model.Classess;
import com.codegym.c0320h1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

//    @Query()
    Iterable<Student> findAllByNameContaining (String name);

    Iterable<Student> findAllByClassess(Classess classes);
}
