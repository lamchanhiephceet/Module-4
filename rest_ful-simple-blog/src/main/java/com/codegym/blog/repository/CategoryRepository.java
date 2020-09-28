package com.codegym.blog.repository;

import com.codegym.blog.model.Category;
import com.codegym.blog.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CategoryRepository<T> {
    List<Category> findAll();
    T findById(Long id);

//    void save(T model);

    void save(Category model);

    void remove(Long id);

}