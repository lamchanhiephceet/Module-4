package com.codegym.springbootmigratewebapp.repositories;


import com.codegym.springbootmigratewebapp.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends CrudRepository<Role, Long> {
}
