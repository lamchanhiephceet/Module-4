package com.codegym.springbootmigratewebapp.repositories;


import com.codegym.springbootmigratewebapp.models.MyUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("myUserRepository")
public interface IMyUserRepository extends CrudRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
