package com.example.demo.service;



import com.example.demo.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

   Object findById(Long id);

    void save(Category category);

    void remove(Long id);
}
