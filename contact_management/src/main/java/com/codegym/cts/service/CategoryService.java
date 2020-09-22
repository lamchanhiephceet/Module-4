package com.codegym.cts.service;

import com.codegym.cts.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}