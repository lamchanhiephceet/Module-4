package com.codegym.cts.repository;

import com.codegym.cts.model.Category;
import com.codegym.cts.model.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
    Iterable<Contact> findAllByCategory(Category category);
}