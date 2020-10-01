package com.codegym.blog.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.codegym.blog.models.Customer;

/**
 * 
 * http://javasampleapproach.com/testing/datajpatest-with-spring-boot
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
}