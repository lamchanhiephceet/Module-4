package com.codegym.cts.service;

import com.codegym.cts.model.Category;
import com.codegym.cts.model.Contact;

public interface ContactService {
    Iterable<Contact> findAll();

    Contact findById(Long id);

    void save(Contact contact);

    void remove(Long id);

    Iterable<Contact> findAllByProvince(Category category);
}