package com.codegym.cts.service.impl;

import com.codegym.cts.model.Category;
import com.codegym.cts.model.Contact;
import com.codegym.cts.repository.ContactRepository;
import com.codegym.cts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void remove(Long id) {
        contactRepository.delete(id);
    }

    @Override
    public Iterable<Contact> findAllByProvince(Category category) {
        return contactRepository.findAllByCategory(category);
    }
}