package com.codegym.blog.service;

import com.codegym.blog.model.Post;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
//    Iterable<Post> findAll();
Page<Post> findAll(Pageable pageable);
Page<Post> findAllByTitleContaining(String title, Pageable pageable);

    Iterable<Post> findAll();

    Post findById(Long id);

    void save(Post post);

    void remove(Long id);

    Iterable<Post> findAllByCategory(Category category);

}
