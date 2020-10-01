package com.codegym.roles.repository;

import com.codegym.roles.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String username);
}