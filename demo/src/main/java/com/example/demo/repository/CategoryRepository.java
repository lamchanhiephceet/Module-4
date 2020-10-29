package com.example.demo.repository;


import com.example.demo.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CategoryRepository<T> {
    List<Category> findAll();
    T findById(Long id);

//    void save(T model);

    void save(Category model);

    void remove(Long id);

}